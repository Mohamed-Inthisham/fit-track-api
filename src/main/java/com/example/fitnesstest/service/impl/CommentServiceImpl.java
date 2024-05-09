package com.example.fitnesstest.service.impl;

import com.example.fitnesstest.DTO.CommentDTO;
import com.example.fitnesstest.entity.Comment;
import com.example.fitnesstest.entity.Post;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.repository.CommentRepository;
import com.example.fitnesstest.repository.PostRepository;
import com.example.fitnesstest.repository.UserRepository;
import com.example.fitnesstest.response.CommentResponse;
import com.example.fitnesstest.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;

    private PostRepository postRepository;

    @Override
    public void createComment(CommentDTO commentDTO, Long uId, Long pId) {

        User user = userRepository.findById(uId)
                .orElseThrow(() -> new EntityNotFoundException("User Not Found" + uId));

        Post post = postRepository.findById(pId)
                .orElseThrow(() -> new EntityNotFoundException("Post Not Found" + pId));

        Comment comment = new Comment();
        comment.setCommentText(commentDTO.getCommentText());
        comment.setUser(user);
        comment.setPost(post);
        comment.setCreatedAt(LocalTime.now());

        commentRepository.save(comment);

    }

    @Override
    public List<CommentResponse> getAllComments(Long id) {

        List<Comment> commentList = commentRepository.findCommentsByPostPostId(id);

//        List<Comment> commentList = commentRepository.findAll();
        List<CommentResponse> commentResponseList = new ArrayList<>();

        for (Comment comment : commentList
        ) {
            CommentResponse commentResponse = new CommentResponse();
            commentResponse.setId(comment.getCommentId());
            commentResponse.setCommentText(comment.getCommentText());
            commentResponse.setUser(comment.getUser());
            commentResponse.setPostId(comment.getPost().getPostId());
            commentResponse.setCreatedAt(comment.getCreatedAt());

            commentResponseList.add(commentResponse);
        }

        return commentResponseList;
    }

    @Override
    public void updateComment(CommentDTO commentDTO, Long cId) {

        Comment comment = commentRepository.findById(cId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found!"));

        comment.setCommentText(commentDTO.getCommentText());

        commentRepository.save(comment);


    }

    @Override
    public void deleteComment(Long id) {
       Comment comment= commentRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("Comment Not Found !")
        );
        commentRepository.deleteById(comment.getCommentId());
    }


}
