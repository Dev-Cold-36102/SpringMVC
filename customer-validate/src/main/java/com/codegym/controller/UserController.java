package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.codegym.service.Imp.UserServiceImp;
import com.codegym.validator.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImp userService;

    @GetMapping("/home")
    public ModelAndView showForm() {
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/signup")
    public ModelAndView checkSignin(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        new UserValidate().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView addView=new ModelAndView("signup");
            return addView;
        }
        if (userService.checkUserExist(user)){
            userService.addUser(user);
            ModelAndView modelAndView=new ModelAndView("result");
            modelAndView.addObject("username",user.getFirstName()+" "+user.getLastName());
            return modelAndView;
        } else {
            ModelAndView modelAndView=new ModelAndView("signup");
            modelAndView.addObject("message","Tài khoản đã tồn tai");
            return modelAndView;
        }

    }


}
