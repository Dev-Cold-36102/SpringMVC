package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {

    private Long id;
    private MultipartFile image;
    private String name;
    private double price;
    private String desc;

    public ProductForm(MultipartFile image, String name, double price, String desc) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public ProductForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
