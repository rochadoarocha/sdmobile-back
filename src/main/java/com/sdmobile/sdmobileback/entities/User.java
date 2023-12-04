package com.sdmobile.sdmobileback.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "users")
@Getter
@Setter
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String username;
	private String password;
	
	
	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public User() {
		
	}

}
