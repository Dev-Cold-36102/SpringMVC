package com.codegym.validator;

import com.codegym.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class UserValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String name = user.getName();
        String password = user.getPassword();
        ValidationUtils.rejectIfEmpty(errors, "name", "value.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "value.empty");

        Pattern patternUpper=Pattern.compile("([A-Z])");
        Pattern patternLower=Pattern.compile("([a-z])");
        Pattern patternNumber=Pattern.compile("([0-9])");
        Pattern patternSpecialCharacter=Pattern.compile("([^A-Za-z0-9])");



        if (name.length() < 5 || name.length() > 15) {
            errors.rejectValue("name", "name.length");
        }

        if (password.length()<6||password.length()>20){
            errors.rejectValue("password","pass.length");
        }

        if (!patternUpper.matcher(password).find()) {
            errors.rejectValue("password","pass.upper");
        }

        if (!patternNumber.matcher(password).find()){
            errors.rejectValue("password","pass.number");
        }

        if (!patternLower.matcher(password).find()){
            errors.rejectValue("password","pass.lower");
        }

        if (!patternSpecialCharacter.matcher(password).find()){
            errors.rejectValue("password","pass.specialcharater");
        }
    }
}
