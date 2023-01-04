package com.example.facebookapp.facebookapi.controllers;

import com.example.facebookapp.facebookapi.entities.User;
import com.example.facebookapp.facebookapi.model.UserLoginDto;
import com.example.facebookapp.facebookapi.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;

@Controller
@Service
@Data
@RequestMapping("/facebook")

public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public  String getLoginPage(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        model.addAttribute("userLoginDto",new UserLoginDto());
        if(session.getAttribute("user")!=null){
            response.sendRedirect("/facebook/index");
        }
        return "login";
    }

    @PostMapping("/login")
    public String validateUser(@ModelAttribute UserLoginDto userLoginDto, Model model, HttpSession session){
        User user=null;
        user= userService.authenticateUser(userLoginDto);
       if(user.getId()!=null){
           session.setAttribute("user",user);
           return "redirect:/facebook/index";
       }
       else{
           session.setAttribute("errorMessage","Wrong username or password");
           return "redirect:/facebook/login";
       }
    }

    @GetMapping("/logout")
    public  void LogOutUser(Model model, HttpSession session, HttpServletResponse response) throws IOException {
            session.invalidate();
            response.sendRedirect("/facebook/login");
    }
}
