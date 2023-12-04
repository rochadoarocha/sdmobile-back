package com.sdmobile.sdmobileback.dto;

import org.springframework.beans.BeanUtils;
import com.sdmobile.sdmobileback.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMinDTO {
	
	private Integer id;
	private String name;
	private String username;
	
	
	public UserMinDTO(User entity) {
		BeanUtils.copyProperties(entity, this);
	}
	
	public UserMinDTO() {
		
	}
	
}
