package com.sdmobile.sdmobileback.dto;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostLikeDTO {
	
	private Integer id_post;
	private Integer id_user;
	private String likes;
	private List<Integer> likedBy;
	
	
	public PostLikeDTO() {
		
	}

	public PostLikeDTO(Integer id_post, Integer id_user, String likes, List<Integer> likedBy) {
		this.id_post = id_post;
		this.id_user = id_user;
		this.likes = likes;
		this.likedBy = likedBy;
	}
	
	
}
