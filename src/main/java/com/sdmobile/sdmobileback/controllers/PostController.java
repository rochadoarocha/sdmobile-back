package com.sdmobile.sdmobileback.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sdmobile.sdmobileback.dto.PostDTO;
import com.sdmobile.sdmobileback.dto.PostDeleteDTO;
import com.sdmobile.sdmobileback.dto.PostLikeDTO;
import com.sdmobile.sdmobileback.entities.Post;
import com.sdmobile.sdmobileback.repositories.IPostsRepository;

@RestController
public class PostController {
	
	@Autowired
	private IPostsRepository postRepository;
	
	
	@GetMapping("api/posts")
	public ResponseEntity<List<Post>> getPosts (){
		List<Post> posts = postRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(posts);
	}
	
	@PostMapping("api/posts")
	public ResponseEntity<?> createPost (@RequestBody PostDTO postDto){
		try {
			Post newPost = new Post(postDto.getText(),postDto.getPublicationDate(),postDto.getLikes(),postDto.getUsername(),postDto.getLikedBy());
			postRepository.save(newPost);
			return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar Post");
		}
		
	}
	
	@PatchMapping("/api/posts")
	public ResponseEntity<?> likePost(@RequestBody PostLikeDTO postLikeDto) {
	    Optional<Post> postToLike = postRepository.findById(postLikeDto.getId_post());

	    if (postToLike.isPresent()) {
	        Post post = postToLike.get();
	        boolean userAlreadyLiked = post.getLikedBy() != null && post.getLikedBy().contains(postLikeDto.getId_user());
	        if (!userAlreadyLiked) {
	            post.getLikedBy().add(postLikeDto.getId_user());
	            post.setLikes(post.getLikes() + 1);
	        } else {
	            post.getLikedBy().remove(postLikeDto.getId_user());
	            post.setLikes(post.getLikes() - 1);
	        }
	        postRepository.save(post);
	        return ResponseEntity.status(HttpStatus.OK).body(post);  
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	@DeleteMapping("api/posts")
	public ResponseEntity<?> deletePost (@RequestBody PostDeleteDTO postDeleteDto){
		Optional<Post> postToDelete = postRepository.findById(postDeleteDto.getPostId());
		if (postToDelete.isPresent()) {
			if (postToDelete.get().getUsername().equals(postDeleteDto.getUsername())){
				postRepository.deleteById(postDeleteDto.getPostId());
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Post deletado");  
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();  
			}
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
		}
		
	}
	

}
