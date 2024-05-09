package com.example.fitnesstest.controller;


import com.example.fitnesstest.DTO.PostDTO;
import com.example.fitnesstest.DTO.UserDTO;
import com.example.fitnesstest.entity.Post;
import com.example.fitnesstest.response.CommonResponse;
import com.example.fitnesstest.response.PostResponse;
import com.example.fitnesstest.response.UserResponse;
import com.example.fitnesstest.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class PostController {
    private PostService postService;

    @PostMapping("/posts/{user_id}")
    public ResponseEntity<CommonResponse> createUser(@RequestBody PostDTO postDTO, @PathVariable ("user_id") Long id)  {

        postService.savePost(postDTO, id);
        return ResponseEntity.ok(new CommonResponse("Post Created"));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<PostResponse> postList = postService.getAllPosts();

        return ResponseEntity.ok(postList);
    }

    @GetMapping("/posts/{post_id}")
    public ResponseEntity<Post> getUserById(@PathVariable("post_id") Long id){
        Post postResponse = postService.getPostById(id);
        return ResponseEntity.ok(postResponse);
    }

    @GetMapping("/posts/user/{user_id}")
    public ResponseEntity<List<PostResponse>> getPostByUserId(@PathVariable("user_id") Long uId){
        List<PostResponse> postResponse = postService.getPostByUserId(uId);
        return ResponseEntity.ok(postResponse);
    }

    @DeleteMapping("/posts/{post_id}")
    public ResponseEntity<?> deleteUser(@PathVariable ("post_id") Long id){
        postService.deletePost(id);

        return ResponseEntity.ok("User Deleted!");
    }
}
