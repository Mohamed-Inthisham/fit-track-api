package com.example.fitnesstest.repository;

import com.example.fitnesstest.entity.Like;
import com.example.fitnesstest.entity.Post;
import com.example.fitnesstest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

//    Like findLikesByPostIdAndUserId(Long pId, Long uId);

    Like findLikesByPostAndUserId(Post post, Long uId);
}
