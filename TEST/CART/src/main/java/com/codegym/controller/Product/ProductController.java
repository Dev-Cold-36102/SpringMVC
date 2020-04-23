package com.codegym.controller.Product;

import com.codegym.model.ProductModel.Product;
import com.codegym.model.ProductModel.ProductForm;
import com.codegym.service.Product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:global_config_app.properties")
public class ProductController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    private Environment environment;
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ModelAndView showProduct() {

        List<Product> products = this.productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/Product/index");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView createProduct() {
        ModelAndView modelAndView = new ModelAndView("/Product/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save-product")
    public ModelAndView saveProduct(@ModelAttribute("ProductForm") ProductForm ProductForm, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/Product/create");
            return modelAndView;
        }
        MultipartFile multipartFile = ProductForm.getImage();
        System.out.println(ProductForm.getName());
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = environment.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(ProductForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Product product = new Product(fileName, ProductForm.getName());

        productService.add(product);

        ModelAndView modelAndView = new ModelAndView("/Product/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }
}
