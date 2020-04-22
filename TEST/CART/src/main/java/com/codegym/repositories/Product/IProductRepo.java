package com.codegym.repositories.Product;

import com.codegym.model.ProductModel.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepo extends PagingAndSortingRepository <Product,Long> {

    Iterable<Product> findAllByNameStartsWith(String name);
}
