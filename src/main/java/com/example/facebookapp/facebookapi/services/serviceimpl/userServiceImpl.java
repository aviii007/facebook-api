package com.decagon.FacebookApp.services.serviceimpl;
import com.decagon.FacebookApp.entities.User;
import com.decagon.FacebookApp.pojos.UserSignUpDto;
import com.decagon.FacebookApp.pojos.UserLoginDto;
import com.decagon.FacebookApp.repositories.UserRepository;
import com.decagon.FacebookApp.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class userServiceImpl implements UserService {
    private  final UserRepository userRepository;

    @Override
    public User registerUser(UserSignUpDto userDto) {
        User user= UserSignUpDto.to(userDto);
        User savedUser=userRepository.save(user);
        return savedUser;
    }
    @Override
    public User getUserById(@NonNull Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User authenticateUser(UserLoginDto userLoginDto) {
        String username= userLoginDto.getUsername();
        String password=userLoginDto.getPassword();
        User user=new User();
        return  user=userRepository.findUserByUsernameAndPassword(username,password).orElse(user);
    }


}
