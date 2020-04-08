package com.codegym.repository.Impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductRepositoryImp implements IProductRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> getAllProduct() {
        TypedQuery<Product> query = this.entityManager.createQuery("select p from Product p", Product.class);

        return query.getResultList();
    }

    @Override
    public void addProduct(Product product) {
        if (product.getId() != null)
            this.entityManager.merge(product);
        else
            this.entityManager.persist(product);
    }


    @Override
    public void removeProduct(Product product) {
        this.entityManager.remove(product);
    }

    @Override
    public void updateProduct(Product product) {
        this.entityManager.merge(product);
    }
}
