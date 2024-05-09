package com.example.fitnesstest.service.impl;

import com.example.fitnesstest.entity.Like;
import com.example.fitnesstest.entity.Post;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.repository.LikeRepository;
import com.example.fitnesstest.repository.PostRepository;
import com.example.fitnesstest.repository.UserRepository;
import com.example.fitnesstest.response.LikeResponse;
import com.example.fitnesstest.service.LikeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private UserRepository userRepository;
    private PostRepository postRepository;
    private LikeRepository likeRepository;

    @Override
    public ResponseEntity<String> saveLike(Long uId, Long pId) {

        User user = userRepository.findById(uId).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        Post post = postRepository.findById(pId).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        Like like = likeRepository.findLikesByPostAndUserId(post, user.getUserId());

       if (like == null){
           System.out.println("like ek null");
           Like likeAdd = new Like();
           likeAdd.setPost(post);
           likeAdd.setUserId(user.getUserId());
           likeAdd.setCreatedAt(LocalTime.now());

           likeRepository.save(likeAdd);
       }else {
           System.out.println("Like tynw");
           likeRepository.deleteById(like.getLikeId());
           return new ResponseEntity<>("Post Unliked Successfully! ", HttpStatus.OK);
       }
        return new ResponseEntity<>("Post Liked Successfully! ", HttpStatus.OK);

    }

    @Override
    public List<LikeResponse> getAll() {

        List<Like> likeList = likeRepository.findAll();
        List<LikeResponse> likeResponsesList = new ArrayList<>();

        for (Like like:likeList
             ) {
            LikeResponse likeResponse = new LikeResponse();
            likeResponse.setLikeId(like.getLikeId());
            likeResponse.setUserId(like.getUserId());
            likeResponse.setPostId(like.getPost().getPostId());

            likeResponsesList.add(likeResponse);
        }
        return likeResponsesList;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {

        Like like = likeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Like not found!"));

        likeRepository.deleteById(like.getLikeId());
        return new ResponseEntity<>("Deleted!",HttpStatus.OK);
    }
}
