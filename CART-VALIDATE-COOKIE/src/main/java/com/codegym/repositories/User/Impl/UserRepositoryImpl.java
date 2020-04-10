package com.codegym.repositories.User.Impl;

import com.codegym.model.UserModel.User;
import com.codegym.repositories.User.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserRepositoryImpl implements IUserRepository {

    @PersistenceContext
    private EntityManager userEntityManager;


    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = this.userEntityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        this.userEntityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        this.userEntityManager.merge(user);
    }
}
