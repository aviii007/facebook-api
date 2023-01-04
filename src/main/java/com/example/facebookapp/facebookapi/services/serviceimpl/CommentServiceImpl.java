package com.decagon.FacebookApp.services.serviceimpl;

import com.decagon.FacebookApp.entities.Comment;
import com.decagon.FacebookApp.entities.Post;
import com.decagon.FacebookApp.entities.User;
import com.decagon.FacebookApp.pojos.CommentDto;
import com.decagon.FacebookApp.repositories.CommentRepository;
import com.decagon.FacebookApp.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private  final CommentRepository commentRepository;
    @Override
    public Comment createComment(CommentDto commentDto) {
        Long userId= commentDto.getUserId();
        Post post=commentDto.getPost();

        String commentDetail= commentDto.getComment();
        Comment comment=new Comment();

        User user= new User();
        user.setId(userId);

        comment.setUser(user);
        comment.setPost(post);
        comment.setComment(commentDetail);
        comment.setCreatedAt(new Date());
        comment.setUpdatedAt(new Date());

        return commentRepository.save(comment);




    }
}
