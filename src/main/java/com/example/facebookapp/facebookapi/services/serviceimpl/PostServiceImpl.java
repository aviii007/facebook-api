package com.decagon.FacebookApp.services.serviceimpl;

import com.decagon.FacebookApp.entities.Post;
import com.decagon.FacebookApp.entities.User;
import com.decagon.FacebookApp.pojos.PostDto;
import com.decagon.FacebookApp.repositories.PostRepository;
import com.decagon.FacebookApp.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private  final PostRepository postRepository;
    @Override
    public Post createPost(PostDto postDto) {
        Post post= new Post();

        String postDescription= postDto.getPost();
        User user=postDto.getUser();

        post.setPost(postDescription);
        post.setUser(user);
        post.setCreatedAt(new Date());
        post.setUpdatedAt(new Date());
        return postRepository.save(post);
    }
    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).get();
    }

}
