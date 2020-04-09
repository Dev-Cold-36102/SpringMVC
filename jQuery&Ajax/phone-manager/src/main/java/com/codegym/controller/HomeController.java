package com.codegym.controller;


import com.codegym.model.Phone;
import com.codegym.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(value = "/smartphones")
public class HomeController {

    @Autowired
    private IPhoneService phoneService;

    @GetMapping("/home")
    public String showIndex(){
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartphonePage() {
        ModelAndView mav = new ModelAndView("create");
        mav.addObject("phone", new Phone());
        mav.addObject("message", "welcome");
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone createSmartphone(@RequestBody Phone phone,Model model) {
        model.addAttribute("message","tao thanh cong");

        return phoneService.save(phone);
    }
}
