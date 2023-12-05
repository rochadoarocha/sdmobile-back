package com.sdmobile.sdmobileback.dto.read;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostReadDto {

    private Integer id;
    private String text;
    private Date publicationDate;
    private UserReadDto user;
    private Integer likes;

 
    
	public PostReadDto(Integer id, String text, Date publicationDate, UserReadDto user, Integer likes) {
		this.id = id;
		this.text = text;
		this.publicationDate = publicationDate;
		this.user = user;
		this.likes = likes;
	}
    
}
