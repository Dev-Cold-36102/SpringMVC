package com.codegym.controller;


import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
    @GetMapping("/login")
    public String LOgin( User user){
        return "login";
    }

    @PostMapping("/login")
    public String home(@ModelAttribute("user") User user, Model model){
        model.addAttribute("username",user.getUsername());
        return "home";
    }
}
