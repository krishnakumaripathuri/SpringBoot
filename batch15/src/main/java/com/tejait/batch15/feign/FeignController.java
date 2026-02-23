package com.tejait.batch15.feign;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("feign")
public class FeignController {
	
	TypiFeign typiFeign;
	
	@GetMapping("getComments")
	public ResponseEntity<List<CommentsDto>> getcomments(){
		List<CommentsDto> comments=typiFeign.getcomments();
		return new ResponseEntity<>(comments,HttpStatus.OK);
	}
	
	@GetMapping("getposts")
	public ResponseEntity<List<CommentsDto>> getposts(){
		List<CommentsDto> posts=typiFeign.getcomments();
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	@GetMapping("getusers")
	public ResponseEntity<List<CommentsDto>> getusers(){
		List<CommentsDto> users=typiFeign.getUsers();
		return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	}


}
