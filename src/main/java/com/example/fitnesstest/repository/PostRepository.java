package com.example.fitnesstest.repository;

import com.example.fitnesstest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostsByUserUserId(Long id);
}
