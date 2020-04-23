package com.codegym.service.Impl;

import com.codegym.model.Country;
import com.codegym.repositories.CountryRepository;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findOne(id);
    }

    @Override
    public void save(Country country) {
        this.countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        this.countryRepository.delete(id);
    }
}
