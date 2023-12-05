package com.sdmobile.sdmobileback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sdmobile.sdmobileback.entities.Like;

public interface ILikeRepository extends JpaRepository<Like, Integer> {
	
	@Query("SELECT l FROM Like l WHERE l.post.id = :postId")
    List<Like> findLikesByPostId(@Param("postId") Integer postId);
	
	@Modifying
    @Query("DELETE FROM Like l WHERE l.post.id = :postId")
    @Transactional
    void deleteLikesByPostId(@Param("postId") Integer postId);

}
