package com.sdmobile.sdmobileback.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.sdmobile.sdmobileback.dto.create.CommentCreateDto;
import com.sdmobile.sdmobileback.dto.delete.CommentDeleteDto;
import com.sdmobile.sdmobileback.dto.read.CommentReadDto;
import com.sdmobile.sdmobileback.dto.read.UserReadDto;
import com.sdmobile.sdmobileback.entities.Comment;
import com.sdmobile.sdmobileback.entities.Post;
import com.sdmobile.sdmobileback.entities.User;
import com.sdmobile.sdmobileback.repositories.ICommentRepository;
import com.sdmobile.sdmobileback.repositories.IPostsRepository;
import com.sdmobile.sdmobileback.repositories.IUserRepository;

@Service
public class CommentService {
	
	@Autowired
	private ICommentRepository commentRepository;
	
	@Autowired
	private IPostsRepository postRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	
	
	public ResponseEntity<?> createComment(@RequestBody CommentCreateDto commentDto){
		try {
			User userToComment = userRepository.findById(commentDto.getUserId()).get();
			Post postToComment = postRepository.findById(commentDto.getPostId()).get();
			Comment newComment = new Comment(commentDto.getText(),commentDto.getCommentDate(),userToComment,postToComment);
			commentRepository.save(newComment);
			UserReadDto userDto = new UserReadDto(newComment.getUser());
		    CommentReadDto commentReadDto = new CommentReadDto(newComment.getId(),newComment.getText(),newComment.getCommentDate(),userDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(commentReadDto);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	
	public ResponseEntity<List<CommentReadDto>> getCommentsByPostID(@PathVariable Integer postId){
		try {
			List<Comment> comments = commentRepository.findCommentsByPostId(postId);
			List<CommentReadDto> commentReadDtos = comments.stream()
		            .map(comment -> {
		            	UserReadDto userDto = new UserReadDto(comment.getUser());
		                CommentReadDto commentReadDto = new CommentReadDto(comment.getId(),comment.getText(),
		                		comment.getCommentDate(),userDto);
		                return commentReadDto;
		            })
		            .collect(Collectors.toList());
			return ResponseEntity.status(HttpStatus.OK).body(commentReadDtos);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public ResponseEntity<?> deleteComment(@RequestBody CommentDeleteDto dto){
		try {
		Comment comment = commentRepository.findById(dto.getId()).get();
		if(comment != null) {
			if(dto.getUserId().equals(comment.getUser().getId())) {
				commentRepository.deleteById(dto.getId());
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
}
