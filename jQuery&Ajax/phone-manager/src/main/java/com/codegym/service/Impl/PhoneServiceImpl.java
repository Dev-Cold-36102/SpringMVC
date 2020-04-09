package com.codegym.service.Impl;

import com.codegym.model.Phone;
import com.codegym.repositories.IPhoneRepository;
import com.codegym.repositories.IPhoneRepositoryDSJR;
import com.codegym.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.List;

public class PhoneServiceImpl implements IPhoneService {

    @Autowired
    private IPhoneRepository phoneRepository;

    @Autowired
    private IPhoneRepositoryDSJR phoneRepositoryDSJR;

    @Override
    public List<Phone> getAll() {
        return (List<Phone>) phoneRepositoryDSJR.findAll();
    }

    @Override
    public Phone findById(Long id) {
        Phone phone = phoneRepositoryDSJR.findOne(id);
        if (phone == null)
            return null;
        return phone;
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepositoryDSJR.save(phone);
    }

    @Override
    public Phone remove(Long id) {
        Phone phone=findById(id);
        phoneRepositoryDSJR.delete(id);
        return phone;
    }
}
