package com.sdmobile.sdmobileback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdmobile.sdmobileback.entities.Post;

public interface IPostsRepository extends JpaRepository <Post, Integer> {

}
