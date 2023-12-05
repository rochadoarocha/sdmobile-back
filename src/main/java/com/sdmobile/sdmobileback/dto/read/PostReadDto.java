package com.sdmobile.sdmobileback.dto.read;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostReadDto {
	
	private Integer id;
	
	private String text;
	
	private Date publicationDate;
	
	private UserReadDto userReadDto;
	
	private List<CommentReadDto> comments;
	
	private List<LikeReadDto> likes;

	public PostReadDto(Integer id, String text, Date publicationDate, UserReadDto userReadDto,
			List<CommentReadDto> comments, List<LikeReadDto> likes) {
		this.id = id;
		this.text = text;
		this.publicationDate = publicationDate;
		this.userReadDto = userReadDto;
		this.comments = comments;
		this.likes = likes;
	}
	
	public PostReadDto() {
		
	}
	
	
	
}
