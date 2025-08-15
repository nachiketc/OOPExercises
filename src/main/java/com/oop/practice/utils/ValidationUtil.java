package com.oop.practice.utils;

import com.oop.practice.pojos.ValidationResponse;

import java.math.BigDecimal;

public final class ValidationUtil {

    private ValidationUtil(){
        // Prevent instantiation
    }

    public static ValidationResponse validateString(String input, String inputName){
        if (input == null || input.trim().isEmpty()){
            return ValidationResponse.invalid(inputName + " cannot be null or empty");
        }
        return ValidationResponse.valid();
    }

    public static ValidationResponse validateNonNull(String input, String inputName){
        if (input == null) {
            return ValidationResponse.invalid(inputName + " cannot be null");
        }
        return ValidationResponse.valid();
    }

    public static ValidationResponse validatePositiveBD(BigDecimal input, String inputName){
        if (input == null || input.compareTo(BigDecimal.ZERO) <= 0) {
            return ValidationResponse.invalid(inputName + " cannot be null or non-positive");
        }
        return ValidationResponse.valid();
    }

    public static ValidationResponse validateBDGreaterThanBD(BigDecimal n1, BigDecimal n2){
        if (n1.compareTo(n2) < 0){
            return ValidationResponse.invalid("Second number is biggar than first number");
        }
        return ValidationResponse.valid();
    }

    public static void validateStringAndThrow(String input, String inputName) {
        if (input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException(inputName + " cannot be null or empty");
        }
    }

    public static void validateGreaterThanIntAndThrow(int input, String inputName, int reference){
        if (input < reference) {
            throw new IllegalArgumentException(inputName + " must be greater than" + String.valueOf(reference));
        }
    }

    public static void validatePositiveBDAndThrow(BigDecimal input, String inputName){
        if (input == null || input.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(inputName + " cannot be null or non-positive");
        }
    }


}
