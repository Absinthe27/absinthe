package com.xude.web.controller;

import java.util.Map;

import javax.validation.Valid;

import com.xude.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xude.exception.BadRequestException;
import com.xude.exception.ResourceNotFoundException;
import com.xude.persistence.model.Comment;
import com.xude.persistence.model.Post;
import com.xude.service.CategoryService;
import com.xude.service.CommentService;
import com.xude.service.PostService;
import com.xude.util.NewPostFormValidator;
import com.xude.web.dto.CommentDto;
import com.xude.web.dto.PostDto;

@Controller
public class PostController {

	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private NewPostFormValidator newPostValidator;

	@Autowired
	ApplicationEventPublisher eventPublisher;

	@RequestMapping(value = "/post/list", method = RequestMethod.GET)
	public String index(Model model) {
		Map<String, Object> attributes = postService.findPosts();
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}
		model.addAttribute(attributes);
		return "fragments/posts-list";
	}

	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public String getPost(Model model, @PathVariable Long postId) {
		if (null == postId) {
			throw new BadRequestException("Path variable postId cound not be null.");
		}
		Map<String, Object> attributes = this.postService.findPostDetailsAndCommentsByPostId(postId);
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}
		model.addAllAttributes(attributes);
		return "forum/post";
	}

	@RequestMapping(value = "/new/{categoryName}", method = RequestMethod.GET)
	public String displayNewPostPageWithCategory(Model model, @PathVariable String categoryName) {
		if (null == categoryName) {
			throw new BadRequestException("Path variable postId cound not be null.");
		}
		Map<String, Object> attributes = this.categoryService.getNewPostPageWithCategoryName(categoryName);
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}
		model.addAllAttributes(attributes);
		return "forum/new-post";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String displayNewPostPage(Model model) {
		Map<String, Object> attributes = this.categoryService.getNewPostPageWithCategorySelect();
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}
		model.addAllAttributes(attributes);
		return "forum/new-post";
	}
	@RequestMapping(value = "/post/hisPosts", method = RequestMethod.GET)
	public String hisPosts(Model model) {

		Map<String, Object> attributes = this.userService.getUserSettingPage();
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}
		model.addAllAttributes(attributes);
		return "forum/user-posts";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String processNewPost(@Valid @ModelAttribute("postDto") PostDto postDto, BindingResult bindingResult,
			Model model) {
		if (null == postDto) {
			throw new BadRequestException("NewPostForm cound not be null.");
		}
		if(postDto.getCategory().length()<2){
			postDto.setCategory("吐槽");
		}
		Post post = this.postService.createNewPost(postDto);

		if (null == post) {
			throw new ResourceNotFoundException("New post object can't be created.");
		}
		// post form validation
		this.newPostValidator.validate(post, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.info("BindingResult has errors >> " + bindingResult.getFieldError());
			return "forum/new-post";
		} else {
			this.postService.save(post);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/post/{postId}", method = RequestMethod.POST)
	public String processNewComment(@PathVariable Long postId,
			@Valid @ModelAttribute("commentDto") CommentDto commentDto) {
		if (null == postId && null == commentDto) {
			throw new BadRequestException("Path variable postId and newCommentForm cound not be null.");
		}
		Comment comment = this.commentService.createNewCommentOnPost(postId, commentDto);
		if (null == comment) {
			throw new ResourceNotFoundException("New comment object can't be created.");
		}
		// comment form validation here ...
		this.commentService.save(comment);
		return "redirect:/post/{postId}";
	}

}