package com.codegym.repositories.Impl;

import com.codegym.model.Phone;
import com.codegym.repositories.IPhoneRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class PhoneRepositoryImpl implements IPhoneRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Phone> getAll() {

        TypedQuery<Phone> query=this.entityManager.createQuery("select p from Phone  p",Phone.class);
        return query.getResultList();
    }

    @Override
    public Phone findById(Long id) {
        return null;
    }

    @Override
    public Phone savePhone(Phone phone) {
        return null;
    }

    @Override
    public Phone removePhone(Long id) {
        return null;
    }
}
