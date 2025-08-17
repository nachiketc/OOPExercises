package com.oop.practice.pojos;

import java.util.Date;

public class LoginAttempt {
    private final boolean isLoginSuccess;
    private final String errorMessage;
    private final Date loginTime;

    private LoginAttempt(boolean isLoginSuccess, String errorMessage, Date loginTime){
        this.isLoginSuccess = isLoginSuccess;
        this.errorMessage = errorMessage;
        this.loginTime = loginTime;
    }

    public static LoginAttempt successfulLogin(){
        return new LoginAttempt(true,"",new Date());
    }

    public static LoginAttempt failedLogin(String errorMessage) {
        return new LoginAttempt(false,errorMessage,new Date());
    }

    public boolean isLoginSuccess() {
        return isLoginSuccess;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
