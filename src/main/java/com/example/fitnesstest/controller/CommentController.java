package com.example.fitnesstest.controller;

import com.example.fitnesstest.DTO.CommentDTO;
import com.example.fitnesstest.DTO.UserDTO;
import com.example.fitnesstest.entity.Comment;
import com.example.fitnesstest.response.CommentResponse;
import com.example.fitnesstest.response.CommonResponse;
import com.example.fitnesstest.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/{user_id}/post/{post_id}")
    public ResponseEntity<String> createComment(@RequestBody CommentDTO commentDTO, @PathVariable("user_id") Long uId, @PathVariable ("post_id") Long pId) {
        commentService.createComment(commentDTO,uId,pId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comment created successfully");
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<List<CommentResponse>> getAllComment(@PathVariable ("post_id") Long id) {
        List<CommentResponse> commentResponseList = commentService.getAllComments(id);

        return ResponseEntity.ok(commentResponseList);
    }

    @PutMapping("/{com_id}")
    public ResponseEntity<?> updateComment(@RequestBody CommentDTO commentDTO, @PathVariable ("com_id") Long cId) throws IOException {
        commentService.updateComment(commentDTO,cId);
        return ResponseEntity.ok("Comment Updated!");
    }

    @DeleteMapping("/{com_id}")
    public ResponseEntity<?> deleteComment(@PathVariable("com_id") Long id) {
        commentService.deleteComment(id);

        return ResponseEntity.ok("comment Deleted!");
    }


}
