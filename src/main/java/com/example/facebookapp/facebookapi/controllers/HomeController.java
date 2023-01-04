package com.example.facebookapp.facebookapi.controllers;

import com.example.facebookapp.facebookapi.entities.Post;
import com.example.facebookapp.facebookapi.entities.User;
import com.example.facebookapp.facebookapi.model.CommentDto;
import com.example.facebookapp.facebookapi.model.PostDto;
import com.example.facebookapp.facebookapi.services.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Service
@Data
@RequestMapping("/facebook")
public class HomeController {
    private final PostService postService;
    @GetMapping("/index")
    public String getPostPage(Model model, HttpSession session){
        session.setAttribute("homepage",true);

        List<Post> allPosts=postService.getAllPost();
        if(session.getAttribute("user")==null)
            return "redirect:/facebook/login";

        model.addAttribute("postDto", new PostDto());
        model.addAttribute("allPosts",allPosts);
        model.addAttribute("commentDto",new CommentDto());
        return "index";
    }

    @PostMapping("/newpost")
    public String addNewPost(@ModelAttribute PostDto postDto) {
        User user= postDto.getUser();
        Long userID= Long.valueOf(postDto.getUser().getId());
        user.setId((userID) );
        postDto.setUser(user);
        postService.createPost(postDto);
        return "redirect:/facebook/index";
    }


    @GetMapping("/single_post_page")
    public String getSinglePost(Model model,HttpSession session, HttpServletRequest request){
        if(session.getAttribute("user")==null){
            return "redirect:/facebook/login";
        }
        Long postID= Long.valueOf(request.getParameter("postID"));
        System.out.println(postID);
        Post singlePost=  postService.getPostById(postID);
        model.addAttribute("singlePost",singlePost);

        session.setAttribute("homepage",false);
        session.setAttribute("postID",postID);
        return "single_post_page";
    }
}
