package com.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

@Controller
@PropertySource("classpath:global_config_app.properties")
public class ProductController {

    @Autowired
    private Environment environment;
}
