package com.example.fitnesstest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    @JsonIgnoreProperties("like_id")
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties("likeList")
    private Post post;


    private Long userId;


    @Column(name = "created_at")
    private LocalTime createdAt;

}