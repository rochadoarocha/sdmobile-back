package com.sdmobile.sdmobileback.dto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.sdmobile.sdmobileback.entities.Post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
	
	
	private String text;
	
	private Date publicationDate;
	
	private Integer likes;
	
	private String username;
	
	private List<Integer> likedBy;
	
	
	public PostDTO (Post entity) {
		BeanUtils.copyProperties(entity, this);
	}
	
	public PostDTO() {
		
	}
}
