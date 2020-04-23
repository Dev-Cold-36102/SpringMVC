package com.codegym.service.Impl;

import com.codegym.model.Picture;
import com.codegym.repositories.IPictureRepository;
import com.codegym.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PictureServiceImpl implements IPictureService {

    @Autowired
    private IPictureRepository pictureRepository;

    @Override
    public void add(Picture picture) {
        this.pictureRepository.add(picture);
    }

    @Override
    public List<Picture> findAll() {
        return this.pictureRepository.findAll();
    }
}
