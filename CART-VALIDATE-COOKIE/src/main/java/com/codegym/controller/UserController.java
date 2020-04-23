package com.codegym.controller;


import com.codegym.model.UserModel.User;
import com.codegym.service.IUserService;
import com.codegym.validator.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    HttpSession httpSession;

    @Autowired
    IUserService userService;


    @GetMapping("/signin")
    public String showForm(@CookieValue(defaultValue = "") String name, @CookieValue(defaultValue = "") String password, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        model.addAttribute("message", "");
        return "sign-in";
    }

    @PostMapping("/signin")
    public String doSignin(@ModelAttribute User user, @RequestParam(defaultValue = "") String rememberMe, HttpServletResponse response, Model model) {
        if (userService.checkSignin(user)) {
            if (rememberMe.equals("remember-me")) {
                Cookie saveName = new Cookie("name", user.getName());
                Cookie savedPassword = new Cookie("password", user.getPassword());

                response.addCookie(saveName);
                response.addCookie(savedPassword);
            }

            model.addAttribute("message", "Đăng nhập thành công");
            return "home";
        } else {
            model.addAttribute("message", "Đăng nhập không thành công");
            return "sign-in";
        }

    }

    @GetMapping("/signup")
    public String showFormSignup(Model model) {
        model.addAttribute("user",new User());
        return "sign-up";
    }

    @PostMapping("/signup")
    public String doSignup(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model, @RequestParam String repassword) {
        new UserValidation().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()){
//            model.addAttribute("message","error");

            return "sign-up";
        }
        if (!user.getPassword().equals(repassword)) {
            model.addAttribute("messageRePass", "pass not match");
            return "sign-up";
        }

        if (userService.isUserExist(user)) {
            model.addAttribute("message", "ten dang nhap da ton tai");
            return "sign-up";
        } else {
            userService.addUser(user);
            model.addAttribute("message", "dang ki thanh cong");
            return "home";
        }
    }
}
