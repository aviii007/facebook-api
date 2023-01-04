package com.example.facebookapp.facebookapi.services;

import com.example.facebookapp.facebookapi.entities.Like;
import com.example.facebookapp.facebookapi.entities.Post;
import com.example.facebookapp.facebookapi.model.LikeDto;
import com.example.facebookapp.facebookapi.repositories.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;

    public Like likePost(LikeDto likeDto){
        Like like= new Like();
        Long userId=likeDto.getUserId();
        Post post=likeDto.getPost();
        like.setUserId(userId);
        like.setPost(post);
        return likeRepository.save(like);

    }

    public void unlikePost(Long id){
        likeRepository.deleteById(id);
    }
}
