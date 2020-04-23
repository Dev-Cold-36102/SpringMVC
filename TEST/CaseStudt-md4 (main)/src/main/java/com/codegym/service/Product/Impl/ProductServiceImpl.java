package com.codegym.service.Product.Impl;

import com.codegym.model.Product.Product;
import com.codegym.repositories.Product.IProductRepository;
import com.codegym.service.Product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        List<Product> products= (List<Product>) this.productRepository.findAll();
        return products;
    }
}
