package com.codegym.repositories;

import com.codegym.models.Comment;
import com.codegym.services.ICommentService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import java.util.List;

public class CommentHibernateRepository implements  ICommentRepository {
    SessionFactory sessionFactory;
    EntityManager entityManager;

    public CommentHibernateRepository() {
        this.sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        this.entityManager = this.sessionFactory.createEntityManager();
    }

    @Override
    public List<Comment> getAllComment() {
        String query="SELECT s FROM Comment s";

        return this.entityManager.createQuery(query,Comment.class).getResultList();
    }
}
