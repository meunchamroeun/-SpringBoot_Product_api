package com.example.product_api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = KhmerNameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface KhmerName {

    String message() default "must contain only Khmer characters and be at most 50 characters long";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
