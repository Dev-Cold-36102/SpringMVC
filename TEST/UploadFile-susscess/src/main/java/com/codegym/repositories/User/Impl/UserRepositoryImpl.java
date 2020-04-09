package com.codegym.repositories.User.Impl;



import com.codegym.model.UserModel.User;
import com.codegym.repositories.User.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class UserRepositoryImpl implements IUserRepository {

    @PersistenceContext
    EntityManager pictureEntityManager;


    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = this.pictureEntityManager.createQuery("select s from User s", User.class);
        return query.getResultList();
//        return null;
    }

    @Override
    public void addUser(User user) {
        this.pictureEntityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        this.pictureEntityManager.merge(user);
    }

}

