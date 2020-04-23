package com.codegym.validator;

import com.codegym.model.City;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CityValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return City.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        City city=(City) target;
        float area=city.getArea();
        int popular=city.getPopular();
        float gdp=city.getGdp();
        String description=city.getDescription();

        if (area<=0){
            errors.rejectValue("area","value_area.moreZero");
        }
        if (popular<=0){
            errors.rejectValue("popular","value_popular.moreZero");
        }

        if (description.length()<100){
            errors.rejectValue("description","description.length");

        }


    }
}
