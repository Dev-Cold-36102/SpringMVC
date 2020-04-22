package com.codegym.service.Product;

import com.codegym.model.ProductModel.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    List<Product> findAll();
}
