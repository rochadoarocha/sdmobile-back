package com.sdmobile.sdmobileback.dto;

import org.springframework.beans.BeanUtils;
import com.sdmobile.sdmobileback.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {
	
	private String username;
	
	private String password;
	
	public UserLoginDTO(User entity) {
		BeanUtils.copyProperties(entity, this);
	}
	
	public UserLoginDTO(){
		
	}


}
