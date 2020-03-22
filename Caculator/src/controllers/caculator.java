package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class caculator {
    @GetMapping("/home")
    public String viewMenu() {
        return "home";
    }

    @PostMapping("/caculator")
    public ModelAndView caculator(@RequestParam int firstOperator, @RequestParam int secondOperator, @RequestParam String operand) {
        int result=0;
        ModelAndView model = new ModelAndView("home");
        model.addObject("firstOperator", firstOperator);
        model.addObject("secondOperator", secondOperator);
        switch (operand) {
            case "+":
                result = firstOperator + secondOperator;
                break;
            case "-":
                result = firstOperator - secondOperator;

                break;
            case "*":
                result = firstOperator * secondOperator;

                break;
            case "/":
                result = firstOperator / secondOperator;

                break;
        }
        model.addObject("result",result);
        return model;

    }
}
