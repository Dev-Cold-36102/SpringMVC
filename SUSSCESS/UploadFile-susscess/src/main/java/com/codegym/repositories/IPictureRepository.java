package com.codegym.repositories;

import com.codegym.model.Picture;

import java.util.List;

public interface IPictureRepository {
    void add(Picture picture);
    List<Picture> findAll();
}
