package com.codegym.repositories.Impl;

import com.codegym.model.User;
import com.codegym.repositories.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class UserRepository implements IUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public UserRepository() {
    }

    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createQuery("select p from User p", User.class);
        return query.getResultList();
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
