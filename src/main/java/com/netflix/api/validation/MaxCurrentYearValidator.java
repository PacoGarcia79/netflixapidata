package com.netflix.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class MaxCurrentYearValidator implements ConstraintValidator<MaxCurrentYear, String> {
    @Override
    public void initialize(MaxCurrentYear constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        int currentYear = LocalDate.now().getYear();
        try {
            int given = value.equals("") ? 0 : Integer.parseInt(value);
            return given <= currentYear;
        } catch(Exception e) {
            return false;
        }
    }
}