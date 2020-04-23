package com.codegym.repositories;

import com.codegym.model.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPhoneRepository  {

    List<Phone> getAll();
    Phone findById(Long id);
    Phone savePhone(Phone phone);
    Phone removePhone(Long id);
}
