package com.sdmobile.sdmobileback.dto.create;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateDto {
	
	private String text;
	
	private Date commentDate;
	
	private Integer userId;
	
	private Integer postId;
	
	
	public CommentCreateDto () {
		
	}

	public CommentCreateDto(String text, Date commentDate, Integer userId, Integer postId) {
		this.text = text;
		this.commentDate = commentDate;
		this.userId = userId;
		this.postId = postId;
	}

}
