package com.example.fitnesstest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "phone_number")
    private String phoneNumber;

    private  String source;

//    @Column(name = "followers")
//    @JsonIgnoreProperties("user")
//    @OneToMany(mappedBy = "user")
//    private List<Follow> followList = new ArrayList<>();

    private Integer followingCount = 0;
    private Integer followersCount = 0;

    @ElementCollection
    @CollectionTable(name = "user_followers", joinColumns = @JoinColumn(name = "follower_id"))
    @Column(name = "following_use_id")
    private List<Long> follower = new ArrayList<>();

    @Column(name = "bio")
    private String bio;

    @Column(name = "account_created")
    private LocalTime accountCreated;



}
