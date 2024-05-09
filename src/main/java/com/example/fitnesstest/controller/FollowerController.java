package com.example.fitnesstest.controller;

import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.response.UserResponse;
import com.example.fitnesstest.service.FollowerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FollowerController {

    private FollowerService followerService;

    @PostMapping("/users/{user_id}/follow/{follower_id}")
    public ResponseEntity<String> addFollowers(@PathVariable("user_id") Long uId, @PathVariable("follower_id") Long fId) {
        return followerService.addFollower(uId, fId);
    }

    @GetMapping("/users/{user_id}/follower/{follow_id}")
    public Boolean checkFollower(@PathVariable("user_id") Long uId, @PathVariable("follow_id") Long fId) {
        return followerService.checkFollowers(uId, fId);
    }

}
