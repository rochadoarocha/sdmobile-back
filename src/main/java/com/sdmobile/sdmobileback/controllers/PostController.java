package com.sdmobile.sdmobileback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sdmobile.sdmobileback.dto.create.PostCreateDto;
import com.sdmobile.sdmobileback.dto.delete.PostDeleteDto;
import com.sdmobile.sdmobileback.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@PostMapping("api/posts")
	public ResponseEntity<?> createPost (@RequestBody PostCreateDto postCreateDto){
		return postService.createPost(postCreateDto);
	}
	
	@GetMapping("api/posts")
	public ResponseEntity<?> getPosts (){
		return postService.getPosts();
	}
	
	@DeleteMapping("api/posts")
	public ResponseEntity<?> deletePost (@RequestBody PostDeleteDto dto){
		return postService.deletePosts(dto);
	}

	@GetMapping("api/posts/{id}")
	public ResponseEntity<?> getPostById (@PathVariable Integer id){
		return postService.getPostById(id);
	}
	

}
