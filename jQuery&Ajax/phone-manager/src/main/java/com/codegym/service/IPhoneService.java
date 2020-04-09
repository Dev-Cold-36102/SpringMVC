package com.codegym.service;

import com.codegym.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> getAll();
    Phone findById(Long id);
    Phone save(Phone phone);
    Phone remove(Long id);
}
