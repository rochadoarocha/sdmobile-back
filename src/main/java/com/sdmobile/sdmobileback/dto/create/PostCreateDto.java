package com.sdmobile.sdmobileback.dto.create;

import java.util.Date;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateDto {
	
	@NotNull(message="Texto do Post não pode ser Nulo")
	private String text;
	
	@NotNull(message="Data de publicação não pode ser nula")
	private Date publicationDate;
	
	@NotNull(message="ID do usuário não pode ser Nulo")
	private Integer userId;
	

	public PostCreateDto(String text, Integer userId, Date publicationDate) {
	    this.text = text;
	    this.userId = userId;
	    this.publicationDate = publicationDate;
	}

	
	public PostCreateDto() {
		
	}
	
	

}
