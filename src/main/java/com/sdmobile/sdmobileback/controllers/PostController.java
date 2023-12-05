package com.sdmobile.sdmobileback.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sdmobile.sdmobileback.dto.create.PostCreateDto;
import com.sdmobile.sdmobileback.dto.delete.PostDeleteDto;
import com.sdmobile.sdmobileback.service.PostService;

import jakarta.validation.Valid;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@PostMapping("api/post")
	public ResponseEntity<?> createPost (@Valid @RequestBody PostCreateDto postCreateDto){
		return postService.createPost(postCreateDto);
	}
	
	@GetMapping("api/post")
	public ResponseEntity<?> getPosts (){
		return postService.getPosts();
	}
	
	@DeleteMapping("api/post")
	public ResponseEntity<?> deletePost (@RequestBody PostDeleteDto dto){
		return postService.deletePosts(dto);
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName,errorMessage);
			});
		return errors;
		
	}
	

}
