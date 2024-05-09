package com.example.fitnesstest.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String profilePictureUrl;
    private String bio;
    private Integer followingCount ;
    private Integer followersCount ;
}
