package com.example.facebookapp.facebookapi.controllers;

import com.example.facebookapp.facebookapi.model.CommentDto;
import com.example.facebookapp.facebookapi.services.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/facebook")
public class CommentController {
    private  final CommentService commentService;
   @PostMapping("/comment")
    public String newComment(@ModelAttribute CommentDto commentDto, HttpSession session) {

       commentService.createComment(commentDto);

       Long postID= (Long) session.getAttribute("postID");

       if((session.getAttribute("homepage")).equals(false))
           return "redirect:/facebook/single_post_page?postID="+postID;
       return "redirect:/facebook/index";
   }
}
