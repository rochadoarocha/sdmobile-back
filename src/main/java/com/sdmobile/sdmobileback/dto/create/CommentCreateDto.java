package com.sdmobile.sdmobileback.dto.create;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateDto {
	
	@NotNull(message="Texto do Post não pode ser Nulo")
	private String text;
	
	@NotNull(message="Data do comentário não pode ser Nulo")
	private Date commentDate;
	
	@NotNull(message="ID do usuário não pode ser Nulo")
	private Integer userId;
	
	@NotNull(message="ID do post não pode ser Nulo")
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
