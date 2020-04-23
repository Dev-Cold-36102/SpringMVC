package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService  {
    List<City> findAllCity();

    City findById(Long id);

    void save(City city);

    void remove(Long id);

    Iterable<City> findAllByProvince(Country country);

}
