package com.example.fitnesstest.service;

import com.example.fitnesstest.DTO.PostDTO;
import com.example.fitnesstest.entity.Post;
import com.example.fitnesstest.response.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    Post savePost(PostDTO postDTO, Long id);

    List<PostResponse> getAllPosts();

    Post getPostById(Long id);

    void deletePost(Long id);

    List<PostResponse> getPostByUserId(Long id);
}
