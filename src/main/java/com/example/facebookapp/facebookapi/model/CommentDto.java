package com.example.facebookapp.facebookapi.model;

import com.example.facebookapp.facebookapi.entities.Post;
import lombok.Data;

@Data
public class CommentDto {
    private  Long userId;
    private Post post;
    private  String comment;

}
