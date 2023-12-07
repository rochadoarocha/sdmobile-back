package com.sdmobile.sdmobileback.dto.read;

import java.util.List;

import com.sdmobile.sdmobileback.entities.Like;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeResponseDto {

    private PostReadDto postReadDto;
    private List<Integer> likedBy;

    public LikeResponseDto(PostReadDto postReadDto, List<Integer> likedBy) {
        this.postReadDto = postReadDto;
        this.likedBy = likedBy;
    }
}

