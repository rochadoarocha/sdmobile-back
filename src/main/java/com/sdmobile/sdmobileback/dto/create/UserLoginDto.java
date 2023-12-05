package com.sdmobile.sdmobileback.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {
	
	
	@NotNull(message="username não pode ser Nulo")
	@NotBlank(message="username não pode está em branco")
	private String username;
	
	@NotNull(message="password não pode ser Nulo")
	@NotBlank(message="password não pode está em branco")
	private String password;
	
	
	public UserLoginDto(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public UserLoginDto() {
		
	}


}
