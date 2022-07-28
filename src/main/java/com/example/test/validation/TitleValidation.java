package com.example.test.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CodeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface  TitleValidation  {

    public String message() default "Bad Request for title string";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
