package com.sdmobile.sdmobileback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdmobile.sdmobileback.entities.User;

public interface IUserRepository extends JpaRepository <User, Integer> {

	User findByUsername(String username);
}
	