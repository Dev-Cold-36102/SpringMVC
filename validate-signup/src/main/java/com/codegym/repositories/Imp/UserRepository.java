package com.codegym.repositories.Imp;

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
    private EntityManager em;

    public UserRepository() {
        System.out.println("UserRepository is instanced");
    }

    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = em.createQuery("select p from User p", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        if (user.getId()!=null){
            em.merge(user);
        } else {
            em.persist(user);
        }

    }
}
