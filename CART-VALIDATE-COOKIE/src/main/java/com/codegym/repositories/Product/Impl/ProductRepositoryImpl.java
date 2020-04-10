package com.codegym.repositories.Product.Impl;

import com.codegym.model.ProductModel.Product;
import com.codegym.repositories.Product.IProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductRepositoryImpl implements IProductRepository {

    @PersistenceContext
    EntityManager productEntityManager;

    @Override
    public List<Product> getAllProduct() {
        TypedQuery<Product> query = this.productEntityManager.createQuery("select p from Product p", Product.class);

        return query.getResultList();
    }

    @Override
    public void addProduct(Product product) {
        if (product.getId() != null)
            this.productEntityManager.merge(product);
        else
            this.productEntityManager.persist(product);
    }


    @Override
    public void removeProduct(Product product) {
        this.productEntityManager.remove(product);
    }

    @Override
    public void updateProduct(Product product) {
        this.productEntityManager.merge(product);
    }
}
