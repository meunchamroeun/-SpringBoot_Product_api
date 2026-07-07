package com.example.product_api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class LatinNameValidator implements ConstraintValidator<LatinName, String> {

    private static final Pattern LATIN_PATTERN = Pattern.compile("^[a-zA-Z\\s]{1,50}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return LATIN_PATTERN.matcher(value).matches();
    }
}
