package com.codegym.repositories.User.Impl;



import com.codegym.model.UserModel.User;
import com.codegym.repositories.User.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class UserRepositoryImpl implements IUserRepository {

    @PersistenceContext
    @Autowired
    public EntityManager entityManager;
//    public EntityManager entityManager;


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

