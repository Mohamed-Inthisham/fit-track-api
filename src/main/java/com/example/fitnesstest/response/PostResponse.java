package com.example.fitnesstest.response;

import com.example.fitnesstest.entity.Like;
import com.example.fitnesstest.entity.User;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
public class PostResponse {
    private Long userId;
    private User user;
    private Long postId;
    private String content;
    private LocalTime createdAt;
    private List<String> mediaList;
    private List<String> likeList;
}
