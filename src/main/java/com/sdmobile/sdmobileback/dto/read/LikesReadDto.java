package com.sdmobile.sdmobileback.dto.read;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikesReadDto {
	
	private Integer id;
	private UserReadDto UsersReadDto;
	
	
	public LikesReadDto(Integer id, UserReadDto userReadDto) {
		this.id = id;
		UsersReadDto = userReadDto;
	}
	
	

}
