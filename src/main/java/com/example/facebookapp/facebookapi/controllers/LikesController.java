package com.example.facebookapp.facebookapi.controllers;

import com.example.facebookapp.facebookapi.entities.Post;
import com.example.facebookapp.facebookapi.model.LikeDto;
import com.example.facebookapp.facebookapi.services.LikeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/facebook")
public class LikesController {
    private final LikeService likeService;

    @GetMapping("/like")
    public String likePost(HttpServletRequest request, HttpSession session){
        LikeDto likeDto=new LikeDto();
        Post post=new Post();

        Long userID= Long.valueOf(request.getParameter("userID"));
        Long postID= Long.valueOf(request.getParameter("postID"));
        likeDto.setUserId(userID);

        post.setId(postID);
        likeDto.setPost(post);
        likeService.likePost(likeDto);

        if((session.getAttribute("homepage")).equals(false))
            return "redirect:/facebook/single_post_page?postID="+postID;
        return "redirect:/facebook/index";

    }

    @GetMapping("/unlike")
    public  String unlikePost(HttpServletRequest request, HttpSession session){
        Long id= Long.valueOf(request.getParameter("likeID"));
        likeService.unlikePost(id);
        Long postID= (Long) session.getAttribute("postID");
        if((session.getAttribute("homepage")).equals(false))
            return "redirect:/facebook/single_post_page?postID="+postID;
        return "redirect:/facebook/index";
    }
}
