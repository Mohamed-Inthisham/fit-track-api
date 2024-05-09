package com.example.fitnesstest.repository;

import com.example.fitnesstest.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByPostPostId(Long id);
}
