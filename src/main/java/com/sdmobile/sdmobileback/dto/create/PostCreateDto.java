package com.sdmobile.sdmobileback.dto.create;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateDto {
	
	private String text;
	
	private Date publicationDate;
	
	private Integer userId;
	

	public PostCreateDto(String text, Integer userId, Date publicationDate) {
	    this.text = text;
	    this.userId = userId;
	    this.publicationDate = publicationDate;
	}

	
	public PostCreateDto() {
		
	}
	
	

}
