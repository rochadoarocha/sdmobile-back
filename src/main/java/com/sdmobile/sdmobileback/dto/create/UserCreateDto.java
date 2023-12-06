package com.sdmobile.sdmobileback.dto.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
	
	private String name;
	
	private String username;
	
	private String password;

	public UserCreateDto(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public UserCreateDto() {
		
	}
	

}
