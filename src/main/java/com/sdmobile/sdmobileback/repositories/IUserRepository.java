package com.sdmobile.sdmobileback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sdmobile.sdmobileback.entities.User;

public interface IUserRepository extends JpaRepository <User, Integer> {

	@Modifying
	@Query("DELETE FROM Comment c WHERE c.user.id = :userId OR c.post.user.id = :userId")
	void deleteCommentsByUserIdAndPostUserId(@Param("userId") Integer userId);

	@Modifying
	@Query("DELETE FROM Like l WHERE l.user.id = :userId OR l.post.user.id = :userId")
	void deleteLikesByUserIdAndPostUserId(@Param("userId") Integer userId);

	@Modifying
	@Query("DELETE FROM Post p WHERE p.user.id = :userId")
	void deletePostByUserId(@Param("userId") Integer userId);

	@Modifying
	@Query("DELETE FROM Like l WHERE l.user.id = :userId")
	void deleteLikesByUserId(@Param("userId") Integer userId);

	@Modifying
	@Query("DELETE FROM Comment c WHERE c.user.id = :userId")
	void deleteCommentsByUserId(@Param("userId") Integer userId);

	User findByUsername(String username);
}
	