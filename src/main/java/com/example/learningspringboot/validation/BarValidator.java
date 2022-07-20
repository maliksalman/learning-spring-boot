package com.example.learningspringboot.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BarValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Bar.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "email", "email.invalid");

        Bar bar = (Bar) target;
        if (bar.getYear() < 1900) {
            errors.rejectValue("year", "year.below-minimum");
        }
    }
}
