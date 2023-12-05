package com.sdmobile.sdmobileback.dto.delete;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDeleteDto {
	
	private Integer postId;
	private Integer userId;
	
	public PostDeleteDto(Integer postId, Integer userId) {
		this.postId = postId;
		this.userId = userId;
	}
	
	public PostDeleteDto() {
	}
	
	

}
