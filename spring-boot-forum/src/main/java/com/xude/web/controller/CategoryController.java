package com.xude.web.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import com.xude.persistence.model.Category;

import com.xude.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.xude.service.PostService;

import javax.validation.Valid;

@Controller
public class CategoryController {

	private static Integer pageSize = 10;

	@Autowired
	private PostService postService;

	@Autowired
	private com.xude.service.CategoryService categoryService;

	@RequestMapping(value = "/category/{categoryName}", method = RequestMethod.GET)
	public String getCategoryPostsByPage(@PathVariable String categoryName, Model model,
			@RequestParam(value = "p", required = false) Integer pageNum) {
		if (null == categoryName) {
			return "error/404";
		}
		int currPage = pageNum == null ? 1 : pageNum;
		Map<String, Object> attributes = this.postService.findPostsListByCategoryByPage(categoryName, currPage,
				pageSize);
		if (null == attributes) {
			return "error/404";
		}
		model.addAllAttributes(attributes);
		return "forum/home";
	}

	@RequestMapping(value = "/category/saveCategory", method = RequestMethod.POST)
	public String saveCategory( Model model,@Valid @ModelAttribute("Category") Category categoryDto,String name) {
		categoryDto.setDisplayName(categoryDto.getName());
		categoryDto.setWeight(3);
		categoryDto.setDateCreated(new Timestamp(System.currentTimeMillis()));
		categoryService.save(categoryDto);

		return "redirect:/";
	}
}
