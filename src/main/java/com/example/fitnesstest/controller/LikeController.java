package com.example.fitnesstest.controller;

import com.example.fitnesstest.entity.Like;
import com.example.fitnesstest.response.LikeResponse;
import com.example.fitnesstest.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LikeController {

    private LikeService likeService;

    @PostMapping("/users/{uId}/post/{pId}")
    public ResponseEntity<String> setLike(@PathVariable Long uId, @PathVariable Long pId) {

        return likeService.saveLike(uId, pId);
    }

    @GetMapping("/users/likes")
    public List<LikeResponse> getAllLikes(){
        return  likeService.getAll();
    }

    @DeleteMapping("/users/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        return likeService.deleteById(id);
    }

//    public ResponseEntity<Object>
}
