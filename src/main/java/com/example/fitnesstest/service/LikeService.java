package com.example.fitnesstest.service;

import com.example.fitnesstest.entity.Like;
import com.example.fitnesstest.response.LikeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeService {
    ResponseEntity<String> saveLike(Long uId, Long pId);

    List<LikeResponse> getAll();

    ResponseEntity<String> deleteById(Long id);
}
