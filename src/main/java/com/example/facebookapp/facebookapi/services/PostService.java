package com.example.facebookapp.facebookapi.services;

import com.example.facebookapp.facebookapi.entities.Post;
import com.example.facebookapp.facebookapi.model.PostDto;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface PostService {
    Post createPost(PostDto postDto);

    List<Post> getAllPost();
    Post getPostById(Long postId);
}
