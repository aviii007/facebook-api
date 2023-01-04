package com.example.facebookapp.facebookapi.services;

import com.example.facebookapp.facebookapi.entities.User;
import com.example.facebookapp.facebookapi.model.UserLoginDto;
import com.example.facebookapp.facebookapi.model.UserSignUpDto;
import lombok.NonNull;

public interface UserService {
    User registerUser(UserSignUpDto userDto);
    User getUserById(@NonNull Long userId);
    User authenticateUser (UserLoginDto userLoginDto);
}
