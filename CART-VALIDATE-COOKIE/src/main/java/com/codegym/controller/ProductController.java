package com.codegym.controller;

import com.codegym.model.ProductModel.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.IProductService;
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

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:global_config_app.properties")
public class ProductController {

    @Autowired
    private Environment environment;
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ModelAndView showProduct(){
        List<Product> products=this.productService.getAllProduct();
        ModelAndView modelAndView=new ModelAndView("product-list");
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView createProduct() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save-product")
    public ModelAndView sveProduct(@ModelAttribute("productForm") ProductForm productForm, BindingResult result){
        if (result.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("create");
            return modelAndView;
        }
        MultipartFile multipartFile=productForm.getImage();
        String fileName=multipartFile.getOriginalFilename();
        String fileUpload=environment.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(),new File(fileUpload+fileName));
        } catch (IOException e){
            e.printStackTrace();
        }

        Product product=new Product(productForm.getName(),fileName,productForm.getPrice(),productForm.getDesc());

        productService.addProduct(product);

        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

}
