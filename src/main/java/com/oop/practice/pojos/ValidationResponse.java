package com.oop.practice.pojos;

import com.oop.practice.utils.ValidationUtil;

public class ValidationResponse {
    private final boolean isValid;
    private final String errorMessage;

    public ValidationResponse(boolean isValid, String errorMessage) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    public static ValidationResponse valid() {
        return new ValidationResponse(true, "");
    }

    public static ValidationResponse invalid(String errorMessage) {
        if (errorMessage == null || errorMessage.trim().isEmpty()){
            throw new IllegalArgumentException("Error message cannot be null or empty");
        }
        return new ValidationResponse(false, errorMessage);
    }

    public boolean isValid(){
        return isValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
