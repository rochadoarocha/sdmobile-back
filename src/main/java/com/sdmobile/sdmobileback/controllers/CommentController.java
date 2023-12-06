	package com.sdmobile.sdmobileback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sdmobile.sdmobileback.dto.create.CommentCreateDto;
import com.sdmobile.sdmobileback.dto.delete.CommentDeleteDto;
import com.sdmobile.sdmobileback.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("api/comments")
	public ResponseEntity<?> createComment (@RequestBody CommentCreateDto commentCreateDto){
		return commentService.createComment(commentCreateDto);

	}
	
	@GetMapping("api/comments/{id}")
	public ResponseEntity<?> getCommentsByPostId (@PathVariable Integer id){
		return commentService.getCommentsByPostID(id);
	}
	
	@DeleteMapping("api/comments")
	public ResponseEntity<?> deleteComment (@RequestBody CommentDeleteDto commentDeleteDto){
		return commentService.deleteComment(commentDeleteDto);
	}

}
