package com.sdmobile.sdmobileback.dto.read;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentReadDto {
	
	private Integer id;
	private String text;
	private Date commentDate;
	private UserReadDto user;
	
	public CommentReadDto(Integer id, String text, Date commentDate, UserReadDto user) {
		this.id = id;
		this.text = text;
		this.commentDate = commentDate;
		this.user = user;
	}
	
	

}
