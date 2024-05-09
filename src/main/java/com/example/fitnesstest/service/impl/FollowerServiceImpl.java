package com.example.fitnesstest.service.impl;

import com.example.fitnesstest.entity.Follow;
import com.example.fitnesstest.entity.Like;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.repository.FollowersRepository;
import com.example.fitnesstest.repository.UserRepository;
import com.example.fitnesstest.response.UserResponse;
import com.example.fitnesstest.service.FollowerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FollowerServiceImpl implements FollowerService {

    private UserRepository userRepository;
    private FollowersRepository followersRepository;
    @Override
    public ResponseEntity<String> addFollower(Long uId, Long fId) {
        User logedInUser = userRepository.findById(uId).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );

        User follower = userRepository.findById(fId).orElseThrow(
                () -> new EntityNotFoundException("follower not found")
        );


        try {
            if (logedInUser.getFollower().contains(fId)){
                logedInUser.getFollower().remove(fId);
//                follower.getFollower().remove(uId);
                logedInUser.setFollowingCount(logedInUser.getFollowingCount()-1);
                follower.setFollowersCount(follower.getFollowersCount()-1);
                userRepository.save(logedInUser);
                return new ResponseEntity<>("User UnFollowed Successfully! ", HttpStatus.OK);
            }

            logedInUser.getFollower().add(follower.getUserId());
            logedInUser.setFollowingCount(logedInUser.getFollowingCount()+1);
            follower.setFollowersCount(follower.getFollowersCount()+1);

            userRepository.save(logedInUser);
            return new ResponseEntity<>("User Followed Successfully! ", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean checkFollowers(Long uId, Long fId) {

        User logedInUser = userRepository.findById(uId).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );

        User follower = userRepository.findById(fId).orElseThrow(
                () -> new EntityNotFoundException("follower not found")
        );


        if (logedInUser.getFollower().contains(fId) && follower.getFollower().contains(uId) ){
            return true;
        }else {
            return false;
        }
    }


}
