package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    private ProductService ProductService = new ProductServiceImpl();

    @GetMapping("/")
    public String index(Model model) {

        List ProductList = ProductService.findAll();
        model.addAttribute("products", ProductList);
        return "/index";
    }
    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/product/save")
    public String save(Product Product, RedirectAttributes redirect) {
        Product.setId((int)(Math.random() * 10000));
        ProductService.save(Product);
        redirect.addFlashAttribute("success", "Saved Product successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", ProductService.findById(id));
        return "/edit";
    }
    @PostMapping("/product/update")
    public String update(Product Product, RedirectAttributes redirect) {
        ProductService.update(Product.getId(), Product);
        redirect.addFlashAttribute("success", "Modified Product successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", ProductService.findById(id));
        return "/delete";
    }
    @PostMapping("/product/delete")
    public String delete(Product Product, RedirectAttributes redirect) {
        ProductService.remove(Product.getId());
        redirect.addFlashAttribute("success", "Removed Product successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", ProductService.findById(id));
        return "/view";
    }
}