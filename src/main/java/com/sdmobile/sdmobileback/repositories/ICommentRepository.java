package com.sdmobile.sdmobileback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sdmobile.sdmobileback.entities.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {
	
	@Query("SELECT c FROM Comment c WHERE c.post.id = :postId")
    List<Comment> findCommentsByPostId(@Param("postId") Integer postId);
	
	@Modifying
	@Query("DELETE FROM Comment c WHERE c.post.id = :postId")
	@Transactional
	void deleteCommentsByPostId(@Param("postId") Integer postId);



}
