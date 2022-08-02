package com.example.test.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TitleValidator implements ConstraintValidator <TitleValidation, String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s != null && s.matches("^[A-Z]{1}[a-z]*_[A-Z]{1}[a-z]*")){
           return true;
        }else {
            return false;
        }
    }
}
