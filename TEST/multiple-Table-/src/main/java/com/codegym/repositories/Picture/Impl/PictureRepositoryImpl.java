package com.codegym.repositories.Picture.Impl;

import com.codegym.model.PictureModel.Picture;
import com.codegym.repositories.Picture.IPictureRepository;

import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Transactional
public class PictureRepositoryImpl implements IPictureRepository {

    @PersistenceContext
    public EntityManager entityManager;

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
        TypedQuery<Picture> query=this.entityManager.createQuery("select p from Picture p", Picture.class);
        System.out.println(query.getResultList().size());
        return query.getResultList();
    }
}
