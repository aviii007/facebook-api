package com.example.facebookapp.facebookapi.services;

import com.example.facebookapp.facebookapi.entities.Comment;
import com.example.facebookapp.facebookapi.model.CommentDto;

public interface CommentService {
    Comment createComment(CommentDto commentDto);
}
