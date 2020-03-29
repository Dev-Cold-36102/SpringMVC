package com.codegym.controllers;


import com.codegym.models.Blog;
import com.codegym.repositories.IBlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private IBlogRepository blogRepository;

    HomeController(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    List<Blog> getAllBlog() {
        return blogRepository.getAllBlog();
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        model.addAttribute("blogs", getAllBlog());
        return "index";
    }

    @GetMapping("/addblog")
    public String getBlogAdd() {
        return "add";
    }

    @PostMapping("/addblog")
    public String addBlog(@ModelAttribute Blog blog,Model model) {
        this.blogRepository.addBlog(blog);
        model.addAttribute("message","add success!");
        return "add";
    }

    @GetMapping("/view")
    public String viewBlog(Model model, @RequestParam String title) {
        List<Blog> blogs = getAllBlog();
        for (Blog blog : blogs) {
            if (blog.getTitle().equals(title)){
                model.addAttribute("blog",blog);
                break;
            }
        }
        return "view";
    }
    @PostMapping("/view")
    public String backHome(){
        return "index";
    }

    @GetMapping("/edit")
    public String showBlogEdit(Model model,@RequestParam String title){
        List<Blog> blogs = getAllBlog();
        for (Blog blog : blogs) {
            if (blog.getTitle().equals(title)){
                model.addAttribute("blog",blog);
                break;
            }
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute Blog blog,Model model){
         this.blogRepository.updateBlog(blog);
        model.addAttribute("message","update success!");
        return "edit";
    }

    @GetMapping("/remove")
    public String getBlogRemove(@RequestParam String title,Model model){
        List<Blog> blogs = getAllBlog();
        for (Blog blog : blogs) {
            if (blog.getTitle().equals(title)){
                model.addAttribute("blog",blog);
                break;
            }
        }
        return "remove";
    }

    @PostMapping("/remove?{titleblog}")
    public String removeBlog(@PathVariable("titleblog") String title, Model model){
        List<Blog> blogs = getAllBlog();
        for (Blog blog : blogs) {
            if (blog.getTitle().equals(title)){
                this.blogRepository.remoteBlog(blog);
                break;
            }
        }
        model.addAttribute("message","remove done!");
        return "remove";
    }

}
