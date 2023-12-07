package com.sdmobile.sdmobileback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sdmobile.sdmobileback.dto.create.UserCreateDto;
import com.sdmobile.sdmobileback.dto.create.UserLoginDto;
import com.sdmobile.sdmobileback.dto.read.UserReadDto;
import com.sdmobile.sdmobileback.entities.User;
import com.sdmobile.sdmobileback.repositories.ICommentRepository;
import com.sdmobile.sdmobileback.repositories.ILikeRepository;
import com.sdmobile.sdmobileback.repositories.IPostsRepository;
import com.sdmobile.sdmobileback.repositories.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private ICommentRepository commentRepository;
	
	@Autowired
	private IPostsRepository postRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ILikeRepository likeRepository;
	
	
	public ResponseEntity<UserReadDto> LoginUser (@RequestBody UserLoginDto userLoginDto){
		try {
		User userToLogin = userRepository.findByUsername(userLoginDto.getUsername());
		if(userToLogin != null) {
			if (userToLogin.getPassword().equals(userLoginDto.getPassword())) {
				UserReadDto userResponse = new UserReadDto(userToLogin);
				return ResponseEntity.status(HttpStatus.OK).body(userResponse);
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public ResponseEntity<UserReadDto> createUser (@RequestBody UserCreateDto userCreateDto){
		try {
			User isUserAlreadyCreated = userRepository.findByUsername(userCreateDto.getUsername());
			if (isUserAlreadyCreated != null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}else {
				User newUser = new User (userCreateDto.getName(),userCreateDto.getUsername(),userCreateDto.getPassword());
				userRepository.save(newUser);
				UserReadDto newUserReadDto = new UserReadDto (newUser);
				return ResponseEntity.status(HttpStatus.CREATED).body(newUserReadDto);
			}

		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	public ResponseEntity<UserReadDto> getUserById(@PathVariable Integer userId){
		try {
		User userToGet = userRepository.findById(userId).get();
		if(userToGet != null) {
			UserReadDto userReadDto = new UserReadDto(userToGet);
			return ResponseEntity.status(HttpStatus.OK).body(userReadDto);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}catch(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
	
	public ResponseEntity<?> deleteUser (@PathVariable Integer userId){
		try {
			User userToDelete = userRepository.findById(userId).get();
			if(userToDelete != null) {
				commentRepository.deleteCommentsByUserId(userId);
				likeRepository.deleteLikesByUserId(userId);
				postRepository.deletePostByUserId(userId);
				userRepository.deleteById(userId);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário Deletado");
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não Encontrado");
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			
		}
	}
}
