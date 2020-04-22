package com.codegym.controller.User;

import com.codegym.model.Product.Product;
import com.codegym.model.User.User;
import com.codegym.service.Product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SercurityController {

    @Autowired
    IProductService productService;

    private String getPrincipal() {
        String role = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            role = String.valueOf(((UserDetails) principal).getAuthorities());
        } else {
            role = null;
        }
        return role;
    }

    @GetMapping(value = {"/", "/home"})
    public String Homepage(Model model) {
        List<Product> products = this.productService.getAllProduct();
        model.addAttribute("user", getPrincipal());
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "index";
    }


    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "index";
    }

    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "index";
    }

    @GetMapping("/login")
    public String showForm(String username, String password, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
//        model.addAttribute("message", "");
        if (getPrincipal() == null) {
            return "login";
        } else{
//            model.addAttribute("user",getPrincipal());
            return "redirect:/";
        }
    }

    @RequestMapping("/signout")
    public String doLogout() {
        return "redirect:/";
    }
}