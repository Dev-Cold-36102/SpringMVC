package com.codegym.repositories.Impl;

import com.codegym.model.User;
import com.codegym.repositories.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserRepository implements IUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
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

    @Override
    public boolean isUserExist(User user) {
        String query = "SELECT u FROM User u WHERE u.name = :name";
        TypedQuery<User> typedQuery = this.entityManager.createQuery(query, User.class);
        typedQuery.setParameter("name", user.getName());
        if (typedQuery.getResultList().size() == 0) {
            return false;
        } else
            return true;
    }
}
