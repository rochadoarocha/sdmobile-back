package com.sdmobile.sdmobileback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.sdmobile.sdmobileback.repositories.IPostsRepository;

@RestController
public class PostController {
	
	@Autowired
	private IPostsRepository postRepository;
	
	

}
