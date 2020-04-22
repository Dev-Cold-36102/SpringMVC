package com.codegym.repositories.Product;

import com.codegym.model.Product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
}
