package com.codegym.repositories.Picture;

import com.codegym.model.PictureModel.Picture;

import java.util.List;

public interface IPictureRepository {
    void add(Picture picture);
    List<Picture> findAll();
}
