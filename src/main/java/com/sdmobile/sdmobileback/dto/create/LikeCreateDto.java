package com.sdmobile.sdmobileback.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeCreateDto {
	
	@NotNull(message="ID do usuário não pode ser Nulo")
	@NotBlank(message="ID do usuário não pode está em branco")
	private Integer userId;
	
	@NotNull(message="ID da publicação não pode ser Nulo")
	@NotBlank(message="ID da publicação não pode está em branco")
	private Integer postId;

	public LikeCreateDto(Integer userId, Integer postId) {
		this.userId = userId;
		this.postId = postId;
	}
	
	public LikeCreateDto() {
		
	}
}
