package com.sdmobile.sdmobileback.dto.create;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.sdmobile.sdmobileback.entities.Comment;
import com.sdmobile.sdmobileback.entities.Like;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateDto {
	
	@NotNull(message="Texto do Post não pode ser Nulo")
	@NotBlank(message="Texto não pode está em branco")
	private String text;
	
	@NotNull(message="Data de publicação não pode ser Nulo")
	@NotBlank(message="Data de publicação não pode está em branco")
	private Date publicationDate;
	
	@NotNull(message="ID do usuário não pode ser Nulo")
	@NotBlank(message="ID do usuário não pode está em branco")
	private Integer userId;
	
	private List<Comment> comments;
	
	private List<Like> likes;

	public PostCreateDto(String text, Date publicationDate, Integer userId, List<Comment> comments, List<Like> likes) {
        this.text = text;
        this.publicationDate = publicationDate;
        this.userId = userId;
        this.comments = comments != null ? comments : Collections.emptyList();
        this.likes = likes != null ? likes : Collections.emptyList();
    }
	
	public PostCreateDto() {
		
	}
	
	

}
