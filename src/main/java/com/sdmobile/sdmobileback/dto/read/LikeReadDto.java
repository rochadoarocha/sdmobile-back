package com.sdmobile.sdmobileback.dto.read;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeReadDto {
	
	private Integer id;
	
	private UserReadDto userReadDto;
	
	private PostReadDto postReadDto;

	public LikeReadDto(Integer id, UserReadDto userReadDto, PostReadDto postReadDto) {
		this.id = id;
		this.userReadDto = userReadDto;
		this.postReadDto = postReadDto;
	}
	
	public LikeReadDto() {
		
	}
	

}
