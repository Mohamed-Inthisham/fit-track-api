package com.example.fitnesstest.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserDTO {

        private String firstName;
        private String lastName;
        private String username;
        private String email;
        private String password;
        private String phoneNumber;
        private String profilePictureUrl;
        private String bio;
        private  String source;



}
