package com.sdmobile.sdmobileback.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sdmobile.sdmobileback.dto.UserLoginDTO;
import com.sdmobile.sdmobileback.dto.UserMinDTO;
import com.sdmobile.sdmobileback.entities.User;
import com.sdmobile.sdmobileback.repositories.IUserRepository;

@RestController
public class UserController {
	
	@Autowired
	private IUserRepository userRepository;
	
	
	@PostMapping("api/login")
	public ResponseEntity<?> loginUser (@RequestBody UserLoginDTO user){
		String username = user.getUsername();
		String password = user.getPassword();
		User userToLogin = userRepository.findByUsername(username);
		if (userToLogin != null) {
			if (password.equals(userToLogin.getPassword())) {
				UserMinDTO userMinDTO = new UserMinDTO(userToLogin);
				return ResponseEntity.status(HttpStatus.OK).body(userMinDTO);
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
		
	}	
}
