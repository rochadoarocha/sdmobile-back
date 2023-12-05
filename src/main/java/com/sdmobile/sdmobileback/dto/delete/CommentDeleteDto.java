package com.sdmobile.sdmobileback.dto.delete;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDeleteDto {
	
	private Integer id;
	private Integer userId;
	
	public CommentDeleteDto(Integer id, Integer userId) {
		this.id = id;
		this.userId = userId;
	}
	
	

}
