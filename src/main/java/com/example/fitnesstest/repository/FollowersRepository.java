package com.example.fitnesstest.repository;

import com.example.fitnesstest.entity.Follow;
import com.example.fitnesstest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowersRepository extends JpaRepository<Follow, Long> {
//
//    Follow findFollowByUserAndFollowerId(User user, Long id);
//
//    List<Follow> findFollowsByFollowerId(Long uId);
//
//    List<User> findFollowsByUser(User user);

}
