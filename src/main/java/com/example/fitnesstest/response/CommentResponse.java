package com.example.fitnesstest.response;

import com.example.fitnesstest.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
public class CommentResponse {

    private Long id;
    private Long postId;
    private User user;
    private LocalTime createdAt;
    private String commentText;
}
