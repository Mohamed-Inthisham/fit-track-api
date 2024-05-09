package com.example.fitnesstest.service.impl;

import com.example.fitnesstest.DTO.PostDTO;
import com.example.fitnesstest.entity.Post;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.repository.PostRepository;
import com.example.fitnesstest.repository.UserRepository;
import com.example.fitnesstest.response.PostResponse;
import com.example.fitnesstest.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class postServiceImpl implements PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;
    @Override
    public Post savePost(PostDTO postDTO, Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User Not Found"));

        Post post = new Post();
        post.setMediaList(postDTO.getMediaList());
        post.setUser(user);
        post.setContent(postDTO.getContent());
        post.setCreatedAt(LocalTime.now());

        return postRepository.save(post);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        List<PostResponse> postResponseList = new ArrayList<>();
        for (Post post : postList) {
            PostResponse response = PostResponse.builder()
                    .postId(post.getPostId())
                    .user(post.getUser())
                    .mediaList(post.getMediaList())
                    .content(post.getContent())
                    .userId(post.getUser().getUserId())
                    .build();
            postResponseList.add(response);
        }
        return postResponseList;
    }

    @Override
    public Post getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        return  post;
    }

    @Override
    public void deletePost(Long id) {

        Optional<Post> postOptional = postRepository.findById(id);

        if (postOptional.isPresent()){
            Post post = postOptional.get();
            postRepository.deleteById(post.getPostId());
        }else {
            throw new EntityNotFoundException("Post with ID " + id + " not found");
        }
    }

    @Override
    public List<PostResponse> getPostByUserId(Long uId) {
        List<Post> postList = postRepository.findPostsByUserUserId(uId);
        List<PostResponse> postResponseList = new ArrayList<>();

        for (Post post: postList
             ) {
            PostResponse postResponse = PostResponse.builder()
                    .postId(post.getPostId())
                    .userId(post.getUser().getUserId())
                    .content(post.getContent())
                    .mediaList(post.getMediaList())
                    .createdAt(post.getCreatedAt())
                    .user(post.getUser())
                    .build();

            postResponseList.add(postResponse);
        }
        return postResponseList;
    }
}
