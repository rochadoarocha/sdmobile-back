package com.sdmobile.sdmobileback.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sdmobile.sdmobileback.dto.create.PostCreateDto;
import com.sdmobile.sdmobileback.dto.delete.PostDeleteDto;
import com.sdmobile.sdmobileback.dto.read.GetPostsFix;
import com.sdmobile.sdmobileback.dto.read.LikeResponseDto;
import com.sdmobile.sdmobileback.dto.read.PostReadDto;
import com.sdmobile.sdmobileback.dto.read.UserReadDto;
import com.sdmobile.sdmobileback.entities.Like;
import com.sdmobile.sdmobileback.entities.Post;
import com.sdmobile.sdmobileback.entities.User;
import com.sdmobile.sdmobileback.repositories.ICommentRepository;
import com.sdmobile.sdmobileback.repositories.ILikeRepository;
import com.sdmobile.sdmobileback.repositories.IPostsRepository;
import com.sdmobile.sdmobileback.repositories.IUserRepository;

@Service
public class PostService {
	
	@Autowired
	private ICommentRepository commentRepository;
	
	@Autowired
	private IPostsRepository postRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ILikeRepository likeRepository;
	
	public ResponseEntity<PostReadDto> createPost(@RequestBody PostCreateDto postCreateDto) {
        try {
        	User userToSet = userRepository.findById(postCreateDto.getUserId()).get();
            Post newPost = new Post(postCreateDto.getText(), postCreateDto.getPublicationDate(),userToSet);
            postRepository.save(newPost);
            List<Like> likes = likeRepository.findLikesByPostId(newPost.getId());
            Integer qtdLikes = likes.size();
            UserReadDto userDto = new UserReadDto(userToSet);
            PostReadDto postToResponse = new PostReadDto(newPost.getId(),newPost.getText(),newPost.getPublicationDate(),userDto,qtdLikes);
            return ResponseEntity.status(HttpStatus.CREATED).body(postToResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	public ResponseEntity<?> getPosts(){
		List<Post> posts = postRepository.findAll();
		List<GetPostsFix> response = posts.stream()
				.map(post -> {
					User user = post.getUser();
					UserReadDto userReadDto = new UserReadDto(user);
					List<Like> likes = likeRepository.findLikesByPostId(post.getId());
					int likesCount = likes.size();
					List<Integer> likedBy = postRepository.findUserIdsByPostId(post.getId());
					return new GetPostsFix(post.getId(), post.getText(), post.getPublicationDate(), userReadDto, likesCount, likedBy);
						})
    			.collect(Collectors.toList());
		Collections.reverse(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
	
	public ResponseEntity<?> deletePosts(@RequestBody PostDeleteDto dto){
		try {
			Post post = postRepository.findById(dto.getPostId()).get();
			if(post != null) {
				Integer userId = post.getUser().getId();
				if(dto.getUserId().equals(userId)) {
					commentRepository.deleteCommentsByPostId(dto.getPostId());
					likeRepository.deleteLikesByPostId(dto.getPostId());
					postRepository.deleteById(dto.getPostId());
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				}else {
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
				}
				
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	public ResponseEntity<?> getPostById (@PathVariable Integer id){
		try {
			Post postToGet = postRepository.findById(id).get();
			if(postToGet != null){
				User user = postToGet.getUser();
                UserReadDto userReadDto = new UserReadDto(user);
				List<Like> likes = likeRepository.findLikesByPostId(id);
                int likesCount = likes.size();
				PostReadDto postReadDto = new PostReadDto(postToGet.getId(), postToGet.getText(), postToGet.getPublicationDate(), userReadDto, likesCount);
				List<Integer> likedBy = postRepository.findUserIdsByPostId(id);
				LikeResponseDto response = new LikeResponseDto(postReadDto,likedBy);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
