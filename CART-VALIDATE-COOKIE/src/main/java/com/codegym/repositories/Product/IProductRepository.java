package com.codegym.repositories.Product;

import com.codegym.model.ProductModel.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();
    void addProduct(Product product);
    void removeProduct(Product product);
    void updateProduct(Product product);
}
