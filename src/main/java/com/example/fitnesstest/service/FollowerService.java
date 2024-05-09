package com.example.fitnesstest.service;

import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowerService {
    ResponseEntity<String> addFollower(Long uId, Long fId);

    Boolean checkFollowers(Long uId, Long fId);


//    ResponseEntity<Object> getAllFollowers(Long uid);
}
