package com.sdmobile.sdmobileback.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=500)
    private String text;

    private Date publicationDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

  
    public Post() {
    }

    public Post(String text, Date publicationDate, User user) {
        this.text = text;
        this.publicationDate = publicationDate;
        this.user = user;
     
    }
    
}



