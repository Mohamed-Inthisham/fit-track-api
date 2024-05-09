package com.example.fitnesstest.response;

import com.example.fitnesstest.entity.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class LikeResponse {

    private Long likeId;
    private Long postId;
    private Long userId;

}
