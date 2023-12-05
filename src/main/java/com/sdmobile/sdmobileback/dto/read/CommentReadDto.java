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
	
	private UserReadDto userReadDto;
	
	private PostReadDto postReadDto;

	public CommentReadDto(Integer id, String text, Date commentDate, UserReadDto userReadDto, PostReadDto postReadDto) {
		this.id = id;
		this.text = text;
		this.commentDate = commentDate;
		this.userReadDto = userReadDto;
		this.postReadDto = postReadDto;
	}
	
	public CommentReadDto() {
		
	}
	
	
}
