package com.tejait.batch15.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "TypiCode", url = "https://jsonplaceholder.typicode.com/") // BASED URL
public interface TypiFeign {

	@GetMapping("comments")        // SUB URL
	public List<CommentsDto> getcomments(); // LIST OF COMMMENTS

	@GetMapping("post")     // SUB URL
	public List<CommentsDto> getPosts(); // LIST OF POSTS
	
	@GetMapping("users")    // SUB URL
	public List<CommentsDto> getUsers();  // LIST OF USERS
}
