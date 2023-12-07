package com.sdmobile.sdmobileback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sdmobile.sdmobileback.entities.Post;

public interface IPostsRepository extends JpaRepository <Post, Integer> {

    @Modifying
    @Query("DELETE FROM Post p WHERE p.user.id = :userId")
    @Transactional
    void deletePostByUserId(@Param("userId") Integer userId);

    @Query("SELECT l.user.id FROM Like l WHERE l.post.id = :postId")
    List<Integer> findUserIdsByPostId(@Param("postId") Integer postId);

}
