package com.oop.practice.models.user;

import com.oop.practice.pojos.LoginAttempt;
import com.oop.practice.utils.PasswordUtil;
import com.oop.practice.utils.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.oop.practice.constants.UserConstants.*;

public class User {
    private final String username;
    private final String hashPassword;
    private boolean isSessionOn;
    private String sessionId;
    private final List<LoginAttempt> loginAttempts;

    public User(String username, String password) {
        ValidationUtil.validateStringAndThrow(username,USER);
        ValidationUtil.validateStringAndThrow(password,PASSWORD);
        this.username = username;
        this.hashPassword = PasswordUtil.hash(password);
        this.isSessionOn = false;
        this.sessionId = "";
        this.loginAttempts = new ArrayList<>();
    }

    public LoginAttempt login(String username,String password) {
        ValidationUtil.validateStringAndThrow(password,PASSWORD);
        ValidationUtil.validateStringAndThrow(username,USERNAME);
        if (isSessionOn){
            return addLoginAttempt(LoginAttempt.failedLogin("Already session going on"));
        }
        ValidationUtil.validateStringAndThrow(username,USER);
        ValidationUtil.validateStringAndThrow(password,PASSWORD);
        if (this.username != username){
            return addLoginAttempt(LoginAttempt.failedLogin("Username does not match"));
        }
        if (!PasswordUtil.verify(password,hashPassword)){
            return addLoginAttempt(LoginAttempt.failedLogin("Password is incorrect"));
        }
        isSessionOn=true;
        sessionId = UUID.randomUUID().toString();
        return addLoginAttempt(LoginAttempt.successfulLogin());
    }

    public void logout() {
        isSessionOn = false;
        sessionId = "";
    }

    public boolean isLoggedIn() {
        return isSessionOn;
    }

    public String getSessionId() {
        return sessionId;
    }

    public List<LoginAttempt> getLoginAttempts() {
        return loginAttempts;
    }

    private LoginAttempt addLoginAttempt(LoginAttempt loginAttempt){
        loginAttempts.add(loginAttempt);
        return loginAttempt;
    }

}
