package com.codegym.service.Product.Impl;

import com.codegym.model.ProductModel.Product;
import com.codegym.repositories.Product.IProductRepo;
import com.codegym.service.Product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepo productRepo;

    @Override
    public void add(Product product) {
        this.productRepo.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) this.productRepo.findAll();
    }
}
