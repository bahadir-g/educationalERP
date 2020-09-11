package com.example.okul.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = {TcKimlikValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TcKimlik {
    String message() default "TC kimlik geçersiz!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
