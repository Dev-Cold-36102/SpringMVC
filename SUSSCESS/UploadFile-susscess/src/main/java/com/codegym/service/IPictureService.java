package com.codegym.service;

import com.codegym.model.Picture;

import java.util.List;

public interface IPictureService {
    void add(Picture picture);
    List<Picture> findAll();
}
