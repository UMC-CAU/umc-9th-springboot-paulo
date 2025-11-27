package com.example.umc_9th_paulo.global.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 1. 값이 아예 없거나(null)
        // 2. 0 이하(1보다 작음)라면
        // false를 반환하여 에러를 발생시킴
        if (value == null || value <= 0) {
            return false;
        }
        return true; // 통과
    }
}