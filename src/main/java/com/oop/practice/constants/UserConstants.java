package com.oop.practice.constants;

public class UserConstants {
    // User related constants
    public static final String USER = "User";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";
    public static final String HASED_PASSWORD = "HashedPassword";
    
    // Password hashing
    public static final int LOG_ROUNDS = 12; // The log_rounds parameter determines the hashing complexity (2^log_rounds iterations)
    
    // Password policy
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PASSWORD_LENGTH = 64;
    public static final int MAX_PASSWORD_ATTEMPTS = 5;
    public static final long LOCKOUT_DURATION_MS = 15 * 60 * 1000; // 15 minutes
    
    // Password complexity patterns
    public static final String UPPERCASE_PATTERN = "(?=.*[A-Z])";
    public static final String LOWERCASE_PATTERN = "(?=.*[a-z])";
    public static final String DIGIT_PATTERN = "(?=.*\\d)";
    public static final String SPECIAL_CHAR_PATTERN = "(?=.*[@#$%^&+=!])";
}
