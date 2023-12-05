package com.sdmobile.sdmobileback.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes;

    public Post() {
    }

    public Post(String text, Date publicationDate, User user, List<Comment> comments, List<Like> likes) {
        this.text = text;
        this.publicationDate = publicationDate;
        this.user = user;
        this.comments = comments;
        this.likes = likes;
    }

    public int getNumberOfLikes() {
        return likes != null ? likes.size() : 0;
    }
}

