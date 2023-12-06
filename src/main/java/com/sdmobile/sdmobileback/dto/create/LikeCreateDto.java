package com.sdmobile.sdmobileback.dto.create;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeCreateDto {
	
	private Integer userId;
	
	private Integer postId;

	public LikeCreateDto(Integer userId, Integer postId) {
		this.userId = userId;
		this.postId = postId;
	}
	
	public LikeCreateDto() {
		
	}
}
