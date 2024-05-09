package com.example.fitnesstest.service;

import com.example.fitnesstest.DTO.CommentDTO;
import com.example.fitnesstest.response.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void createComment(CommentDTO commentDTO, Long uId, Long pId);

    List<CommentResponse> getAllComments(Long id);

    void updateComment(CommentDTO commentDTO, Long cId);

    void deleteComment(Long id);
}
