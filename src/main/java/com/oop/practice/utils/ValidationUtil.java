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

    public static ValidationResponse validateRangeInt(int input, String inputName, int lowerBound, int upperBound) {
        if (input < lowerBound ){
            return ValidationResponse.invalid(inputName + " cannot be less than " + lowerBound);
        } else if (input > upperBound) {
            return ValidationResponse.invalid(inputName + " cannot be greater than " + upperBound);
        }
        return ValidationResponse.valid();
    }

    public static ValidationResponse validateGreaterThanInt(int input, String inputName, int reference) {
        if (input<reference) {
            return ValidationResponse.invalid(inputName + " cannot be less than " + reference);
        }
        return ValidationResponse.valid();
    }

    public static ValidationResponse validatePositiveInt(int input, String inputName) {
        if (input < 0){
            return ValidationResponse.invalid(inputName + " cannot be negative");
        }
        return ValidationResponse.valid();
    }

    public static ValidationResponse validateBDGreaterThanBD(BigDecimal n1, BigDecimal n2){
        if (n1.compareTo(n2) < 0){
            return ValidationResponse.invalid("Second number is biggar than first number");
        }
        return ValidationResponse.valid();
    }

    public static void validateNonNullAndThrow(Object input, String inputName){
        if (input == null) {
            throw new IllegalArgumentException(inputName + " cannot be null");
        }
    }

    public static void validateStringAndThrow(String input, String inputName) {
        if (input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException(inputName + " cannot be null or empty");
        }
    }

    public static void validateRangeIntAndThrow(int input, String inputName, int lowerBound, int upperBound) {
        if (input < lowerBound ){
            throw new IllegalArgumentException(inputName + " cannot be less than " + lowerBound);
        } else if (input > upperBound) {
            throw new IllegalArgumentException(inputName + " cannot be greater than " + upperBound);
        }
    }

    public static void validateGreaterThanIntAndThrow(int input, String inputName, int reference){
        if (input < reference) {
            throw new IllegalArgumentException(inputName + " must be greater than" + String.valueOf(reference));
        }
    }

    public static void validatePositiveIntAndThrow(int input, String inputName) {
        if (input < 0){
           throw new IllegalArgumentException(inputName + " cannot be negative");
        }
    }

    public static void validatePositiveBDAndThrow(BigDecimal input, String inputName){
        if (input == null || input.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(inputName + " cannot be null or non-positive");
        }
    }

}
