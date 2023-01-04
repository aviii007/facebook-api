package com.example.facebookapp.facebookapi.model;

import com.example.facebookapp.facebookapi.entities.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserSignUpDto {
    private  String fullName;
    private  String email;
    private String gender;
    private  String username;
    private  String password;

    public static User to(UserSignUpDto userSignUpDto){
        User user= new User();

        user.setFullName(userSignUpDto.getFullName());
        user.setEmail(userSignUpDto.getEmail());
        user.setGender(userSignUpDto.getGender());
        user.setUsername(userSignUpDto.getUsername());
        user.setPassword(userSignUpDto.getPassword());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        return  user;

    }
}
