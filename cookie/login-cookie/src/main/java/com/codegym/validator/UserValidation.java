package com.codegym.validator;

import com.codegym.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class UserValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String name = user.getName();
        String password = user.getPassword();
        ValidationUtils.rejectIfEmpty(errors, "name", "value.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "value.empty");

        if (name.length() < 5 || name.length() > 15) {
            errors.rejectValue("name", "name.length");
        }

        if (password.length()<6||password.length()>20){
            errors.rejectValue("password","pass.length");
        }

        if (!Pattern.matches("[A-Z]+?", password)) {
            errors.rejectValue("password","pass.upper");
        }

        if (!Pattern.matches("[0-9]+?",password)){
            errors.rejectValue("password","pass.number");
        }

        if (!Pattern.matches("[^A-Za-z0-9]+?",password)){
            errors.rejectValue("password","pass.specialcharater");
        }
    }
}
