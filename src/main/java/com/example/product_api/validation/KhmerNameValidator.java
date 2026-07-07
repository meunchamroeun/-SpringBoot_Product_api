package com.example.product_api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class KhmerNameValidator implements ConstraintValidator<KhmerName, String> {

    private static final Pattern KHMER_PATTERN = Pattern.compile("^[\\u1780-\\u17FF\\s]{1,50}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return KHMER_PATTERN.matcher(value).matches();
    }
}
