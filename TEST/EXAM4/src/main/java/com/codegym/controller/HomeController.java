package com.codegym.controller;


import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import com.codegym.validator.CityValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    public CountryService countryService;

    @Autowired
    CityService cityService;

    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return countryService.findAll();
    }

    @RequestMapping("/home")
    public String home(Model model) {
        List<City> cities = this.cityService.findAllCity();
        model.addAttribute("cities", cities);
        System.out.println(cities.get(0).getName());
        return "home";
    }

    @GetMapping("/view/{id}")
    public String viewCity(@PathVariable("id") Long id, Model model) {
        City city = this.cityService.findById(id);
        model.addAttribute("city", city);
        return "view-single";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("city", new City());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("city") City city, BindingResult bindingResult, Model model) {
        new CityValidate().validate(city, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        this.cityService.save(city);
        model.addAttribute("message", "them thanh cong");
        return "redirect:/home";


    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id, Model model) {
        City city = this.cityService.findById(id);
        model.addAttribute("city", city);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@ModelAttribute("city") City city, @PathVariable("id") Long id, Model model, BindingResult bindingResult) {
        new CityValidate().validate(city, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {


            City citySave = this.cityService.findById(id);
            citySave.setName(city.getName());
            citySave.setArea(city.getArea());
            citySave.setCountry(city.getCountry());
            citySave.setDescription(city.getDescription());
            citySave.setGdp(city.getGdp());
            citySave.setPopular(city.getPopular());
            this.cityService.save(citySave);
            model.addAttribute("message", "Sua thanh cong");
            return "redirect:/home";
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody()
    public String doDelete(@PathVariable("id") Long id) {
        System.out.println(id);
        this.cityService.remove(id);
        return "true";
    }

}
