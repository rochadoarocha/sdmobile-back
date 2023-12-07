package com.sdmobile.sdmobileback.dto.read;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPostsFix {

    private Integer id;
    private String text;
    private Date publicationDate;
    private UserReadDto user;
    private Integer likes;
    private List<Integer> likedBy;

 
	public GetPostsFix (Integer id, String text, Date publicationDate, UserReadDto user, Integer likes, List<Integer> likedBy) {
		this.id = id;
		this.text = text;
		this.publicationDate = publicationDate;
		this.user = user;
		this.likes = likes;
        this.likedBy = likedBy;
	}
    
}

    
