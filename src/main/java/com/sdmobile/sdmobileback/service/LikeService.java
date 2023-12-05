package com.sdmobile.sdmobileback.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sdmobile.sdmobileback.dto.create.LikeCreateDto;
import com.sdmobile.sdmobileback.dto.read.LikesReadDto;
import com.sdmobile.sdmobileback.dto.read.UserReadDto;
import com.sdmobile.sdmobileback.entities.Like;
import com.sdmobile.sdmobileback.entities.Post;
import com.sdmobile.sdmobileback.entities.User;
import com.sdmobile.sdmobileback.repositories.ILikeRepository;
import com.sdmobile.sdmobileback.repositories.IPostsRepository;
import com.sdmobile.sdmobileback.repositories.IUserRepository;

@Service
public class LikeService {
	
	@Autowired
	private IPostsRepository postRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ILikeRepository likeRepository;
	
	
	public ResponseEntity<?> toggleLike(LikeCreateDto likeCreateDto) {
		try {
	        Optional<Post> postOptional = postRepository.findById(likeCreateDto.getPostId());
	        if (postOptional.isEmpty()) {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado pelo ID do mesmo" + likeCreateDto.getUserId());
	        }
	        Optional<User> userOptional = userRepository.findById(likeCreateDto.getUserId());
	        if (userOptional.isEmpty()) {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado com o ID: " + likeCreateDto.getUserId());
	        }
	        Optional<Like> existingLike = likeRepository.findByUserIdAndPostId(likeCreateDto.getUserId(), likeCreateDto.getPostId());
	        if (existingLike.isPresent()) {
	            likeRepository.deleteById(existingLike.get().getId());
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        } else {
	            Like newLike = new Like();
	            newLike.setUser(userOptional.get());
	            newLike.setPost(postOptional.get());
	            likeRepository.save(newLike);
	            return ResponseEntity.status(HttpStatus.CREATED).build();
	        }
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	public ResponseEntity<?> getLikesByPostId (@PathVariable Integer postId){
		try {
			List<Like> likes = likeRepository.findLikesByPostId(postId);
			List<LikesReadDto> likesReadDtos = likes.stream().map(like -> {
						User user = like.getUser();
						UserReadDto userReadDto = new UserReadDto(user);
						return new LikesReadDto(like.getId(), userReadDto);
	                }).collect(Collectors.toList());
			return ResponseEntity.status(HttpStatus.OK).body(likesReadDtos);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
