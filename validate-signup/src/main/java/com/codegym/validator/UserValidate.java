package com.codegym.validator;

import com.codegym.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidate implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String phoneNumber = user.getPhoneNumber();
        int age = user.getAge();

        ValidationUtils.rejectIfEmpty(errors, "firstName", "value.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "value.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "value.empty");
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "value.empty");
        ValidationUtils.rejectIfEmpty(errors, "age", "value.empty");

        if (firstName.length() < 5 || firstName.length() > 30
                || lastName.length() < 5 || lastName.length() > 30) {
            errors.rejectValue("firstName", "username.length");
            errors.rejectValue("lastName", "username.length");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startWith");
        }
        if (!phoneNumber.matches("((^$|[0-9]*$))")) {
            errors.rejectValue("phoneNumber", "number.matches");
        }

        if (age < 18) {
            errors.rejectValue("age", "age.value");
        }

        if (!email.matches("(^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$)")) {
            errors.rejectValue("email", "email.format");
        }
    }
}
