package com.sdmobile.sdmobileback.dto.read;

import org.springframework.beans.BeanUtils;

import com.sdmobile.sdmobileback.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReadDto {
	
	private Integer id;
	private String name;
	private String username;
	
	
	public UserReadDto(User entity) {
		BeanUtils.copyProperties(entity, this);
	}
	
	public UserReadDto() {
		
	}
	
	
}
