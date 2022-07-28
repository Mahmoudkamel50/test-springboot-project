package com.example.test.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodeValidator implements ConstraintValidator <TitleValidation, String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s != null && s.matches("^[A-Z][a-zA-Z\\s]*$")){
           return true;
        }else {
            return false;
        }
    }
}
