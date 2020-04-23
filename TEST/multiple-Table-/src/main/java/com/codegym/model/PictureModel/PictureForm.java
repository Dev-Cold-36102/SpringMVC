package com.codegym.model.PictureModel;

import org.springframework.web.multipart.MultipartFile;

public class PictureForm {

    private Long id;
    private MultipartFile image;
    private String name;

    public PictureForm(Long id, MultipartFile image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public PictureForm(MultipartFile image, String name) {
        this.image = image;
        this.name = name;
    }

    public PictureForm() {
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
}
