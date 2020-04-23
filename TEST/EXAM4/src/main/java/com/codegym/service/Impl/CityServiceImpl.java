package com.codegym.service.Impl;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.repositories.CityRepository;
import com.codegym.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAllCity() {
        List<City> cities = (List<City>) this.cityRepository.findAll();
        System.out.println(cities.size());
        return cities;
    }

    @Override
    public City findById(Long id) {
        return this.cityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        this.cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        this.cityRepository.delete(id);
    }

    @Override
    public Iterable<City> findAllByProvince(Country country) {
        return null;
    }
}
