package com.sdmobile.sdmobileback.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String text;
	
	private Date publicationDate;
	
	private Integer likes;
	
	private String username;
	
	@ElementCollection
	private List<Integer> likedBy;
	
	public Post() {
		
	}

	public Post(String text, Date publicationDate, Integer likes, String username, List<Integer> likedBy) {
		this.text = text;
		this.publicationDate = publicationDate;
		this.likes = likes;
		this.username = username;
		this.likedBy = likedBy;
	}
	
	

	
}
