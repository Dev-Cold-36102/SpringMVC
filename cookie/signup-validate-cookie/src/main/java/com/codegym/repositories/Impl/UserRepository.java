package com.codegym.repositories.Impl;

import com.codegym.model.User;
import com.codegym.repositories.IUserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class UserRepository implements IUserRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = this.entityManager.createQuery("select s from User s", User.class);
        return query.getResultList();
//        return null;
    }

    @Override
    public void addUser(User user) {
        this.entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        this.entityManager.merge(user);
    }

}
