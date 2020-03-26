package com.codegym.controllers;


import com.codegym.models.Blog;
import com.codegym.repositories.IBlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private IBlogRepository blogRepository;
    HomeController(IBlogRepository blogRepository){
        this.blogRepository=blogRepository;
    }

    List<Blog> getAllBlog(){
        return blogRepository.getAllBlog();
    }

    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("blogs",getAllBlog());
        return "index";
    }

    @GetMapping("/addblog")
    public String getBlogAdd(){
        return "add";
    }

    @PostMapping("/addblog")
    public String addBlog(@ModelAttribute Blog blog){
        this.blogRepository.addBlog(blog);
        return "redirect:/home";
    }

}
