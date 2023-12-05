package com.sdmobile.sdmobileback.controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sdmobile.sdmobileback.dto.create.UserCreateDto;
import com.sdmobile.sdmobileback.dto.create.UserLoginDto;
import com.sdmobile.sdmobileback.dto.read.UserReadDto;
import com.sdmobile.sdmobileback.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Operation(summary = "Login User", description = "Endpoint to login a user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully logged in.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserReadDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized - Incorrect username or password."),
            @ApiResponse(responseCode = "404", description = "Not Found - User not found."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")
    })
	@PostMapping("api/login")
	public ResponseEntity<UserReadDto> loginUser (@Valid @RequestBody UserLoginDto userLoginDto){
		return userService.LoginUser(userLoginDto);
	}
	
	
	@Operation(summary = "Create User", description = "Endpoint to create a new user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully created.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserReadDto.class))),
            @ApiResponse(responseCode = "409", description = "Conflict - User already exists."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")
    })
	@PostMapping("api/user")
	public ResponseEntity<UserReadDto> createUser (@Valid @RequestBody UserCreateDto userCreateDto){
		return userService.createUser(userCreateDto);
	}
	
	@Operation(summary = "Delete User", description = "Endpoint to delete a user by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User successfully deleted."),
            @ApiResponse(responseCode = "404", description = "Not Found - User not found."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")
    })
	@DeleteMapping("api/user")
	public ResponseEntity<?> deleteUser (@PathVariable Integer userId){
		return userService.deleteUser(userId);
	}
	
	@Operation(summary = "Get User by ID", description = "Endpoint to retrieve a user by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully retrieved.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserReadDto.class))),
            @ApiResponse(responseCode = "404", description = "Not Found - User not found."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")
    })
	@GetMapping("api/user/{id}")
	public ResponseEntity<UserReadDto> getUserById(@PathVariable Integer id){
		return userService.getUserById(id);
	}
	
	
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName,errorMessage);
			errors.put(fieldName,errorMessage);
			});
		return errors;
		
	}
	
}
