package com.codegym.service;

import com.codegym.model.ProductModel.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    void addProduct(Product product);
    void removeProduct(Product product);
    void updateProduct(Product product);
}
