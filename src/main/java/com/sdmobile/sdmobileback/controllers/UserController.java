package com.sdmobile.sdmobileback.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sdmobile.sdmobileback.dto.create.UserCreateDto;
import com.sdmobile.sdmobileback.dto.create.UserLoginDto;
import com.sdmobile.sdmobileback.dto.read.UserReadDto;
import com.sdmobile.sdmobileback.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("api/login")
	public ResponseEntity<UserReadDto> loginUser (@RequestBody UserLoginDto userLoginDto){
		return userService.LoginUser(userLoginDto);
	}
	
	
	@PostMapping("api/user")
	public ResponseEntity<UserReadDto> createUser (@RequestBody UserCreateDto userCreateDto){
		return userService.createUser(userCreateDto);
	}
	
	
	@DeleteMapping("api/user/{id}")
	public ResponseEntity<?> deleteUser (@PathVariable Integer id){
		return userService.deleteUser(id);
	}
	

	@GetMapping("api/user/{id}")
	public ResponseEntity<UserReadDto> getUserById(@PathVariable Integer id){
		return userService.getUserById(id);
	}
	
}
