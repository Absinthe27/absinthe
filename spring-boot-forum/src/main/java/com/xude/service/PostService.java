package com.xude.service;

import java.util.List;
import java.util.Map;

import com.xude.persistence.model.Post;
import com.xude.web.dto.PostDto;

public interface PostService {

	void save(Post post);

	void delete(Long postId);

	void update(Post post);

	Post findById(Long id);

	List<Post> findPostsByUserId(Long id);

	Post createNewPost(PostDto newPostForm);

	int deletePostAndComments(Long postId);

	Map<String, Object> findPosts();

	Map<String, Object> findPostsByPage(int currPage, int pageSize);

	Map<String, Object> findPostsListByCategoryByPage(String categoryName, int currPage, int pageSize);

	Map<String, Object> findPostDetailsAndCommentsByPostId(Long postId);

	Map<String, Object> findPostsBetweenDateRange(String start, String end);
	Map<String, Object> findPostsOrderByCommontDate();
}
