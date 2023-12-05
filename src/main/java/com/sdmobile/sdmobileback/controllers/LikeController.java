package com.sdmobile.sdmobileback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sdmobile.sdmobileback.dto.create.LikeCreateDto;
import com.sdmobile.sdmobileback.service.LikeService;

@RestController
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	
	@PostMapping("api/like")
	public ResponseEntity<?> toggleLike(@RequestBody LikeCreateDto likeCreateDto){
		return likeService.toggleLike(likeCreateDto);
	}
	
	@GetMapping("api/like/{id}")
	public ResponseEntity<?> getLikeByPostId(@PathVariable Integer id){
		return likeService.getLikesByPostId(id);
	}

}
