package com.example.facebookapp.facebookapi.model;

import com.example.facebookapp.facebookapi.entities.Post;
import lombok.Data;

@Data
public class LikeDto {
    private Long userId;
    private Post post;
}
