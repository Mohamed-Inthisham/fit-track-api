package com.example.fitnesstest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("user")
    private User user;


    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalTime createdAt;



    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("post")
    private List<Like> likeList = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "post_media", joinColumns = @JoinColumn(name = "media_id"))
    @Column(name = "media_list")
    private List<String> mediaList;

}