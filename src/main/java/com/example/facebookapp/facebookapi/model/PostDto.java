package com.example.facebookapp.facebookapi.model;

import com.example.facebookapp.facebookapi.entities.User;
import lombok.Data;

@Data
public class PostDto {
    private User user;
    private  String post;
}
