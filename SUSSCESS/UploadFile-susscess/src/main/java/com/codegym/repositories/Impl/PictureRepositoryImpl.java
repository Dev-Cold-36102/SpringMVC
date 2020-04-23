package com.codegym.repositories.Impl;

import com.codegym.model.Picture;
import com.codegym.repositories.IPictureRepository;
import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Transactional
public class PictureRepositoryImpl implements IPictureRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(Picture picture) {
        if (picture.getId() != null) {
            entityManager.merge(picture);
        } else {
            System.out.println(picture.getImage());
            entityManager.persist(picture);
        }
    }

    @Override
    public List<Picture> findAll() {

        TypedQuery<Picture> query=entityManager.createQuery("select p from Picture p",Picture.class);

        return query.getResultList();
    }
}
