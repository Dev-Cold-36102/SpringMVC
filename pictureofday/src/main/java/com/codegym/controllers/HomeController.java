package com.codegym.controllers;


import com.codegym.models.Comment;
import com.codegym.services.ICommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private ICommentService commentService;
    HomeController(ICommentService commentService){
        this.commentService=commentService;
    }
    List<Comment> getComment(){
        return commentService.getAllComment();
    }

    @GetMapping("/home")
    public String getIndex(Model model){
        model.addAttribute("comments",getComment());
        return "index";
    }


}
