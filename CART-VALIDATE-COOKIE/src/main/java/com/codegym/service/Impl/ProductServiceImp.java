package com.codegym.service.Impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImp implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.getAllProduct();
    }

    @Override
    public void addProduct(Product product) {
        this.productRepository.addProduct(product);
    }

    @Override
    public void removeProduct(Product product) {
        this.productRepository.removeProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        this.productRepository.updateProduct(product);
    }
}
