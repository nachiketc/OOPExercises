package com.oop.practice.utils;

import com.oop.practice.pojos.ValidationResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.oop.practice.constants.UserConstants.*;

public final class PasswordUtil {
    // Password complexity patterns (compiled from constants)
    private static final Pattern UPPERCASE_PATTERN_COMPILED = Pattern.compile(UPPERCASE_PATTERN);
    private static final Pattern LOWERCASE_PATTERN_COMPILED = Pattern.compile(LOWERCASE_PATTERN);
    private static final Pattern DIGIT_PATTERN_COMPILED = Pattern.compile(DIGIT_PATTERN);
    private static final Pattern SPECIAL_CHAR_PATTERN_COMPILED = Pattern.compile(SPECIAL_CHAR_PATTERN);
    
    private PasswordUtil() {
        // Prevent instantiation
    }

    public static String hash(String plainPassword) {
        ValidationResponse validationResponse = validatePassword(plainPassword);
        if (!validationResponse.isValid()) {
            throw new IllegalArgumentException(validationResponse.getErrorMessage());
        }
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(LOG_ROUNDS));
    }
    
    public static ValidationResponse validatePassword(String password) {
        List<String> errors = new ArrayList<>();
        
        // Check length
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            errors.add(String.format("Password must be at least %d characters long", MIN_PASSWORD_LENGTH));
        }
        if (password != null && password.length() > MAX_PASSWORD_LENGTH) {
            errors.add(String.format("Password cannot be longer than %d characters", MAX_PASSWORD_LENGTH));
        }
        
        // Check complexity
        if (password != null) {
            if (!UPPERCASE_PATTERN_COMPILED.matcher(password).find()) {
                errors.add("Password must contain at least one uppercase letter");
            }
            if (!LOWERCASE_PATTERN_COMPILED.matcher(password).find()) {
                errors.add("Password must contain at least one lowercase letter");
            }
            if (!DIGIT_PATTERN_COMPILED.matcher(password).find()) {
                errors.add("Password must contain at least one digit");
            }
            if (!SPECIAL_CHAR_PATTERN_COMPILED.matcher(password).find()) {
                errors.add("Password must contain at least one special character (@#$%^&+=!)");
            }
        }
        
        if (errors.isEmpty()) {
            return ValidationResponse.valid();
        } else {
            return ValidationResponse.invalid(String.join(", ", errors));
        }
    }
    
    public static boolean isAccountLocked(long lastFailedAttemptTime, int failedAttempts) {
        if (failedAttempts >= MAX_PASSWORD_ATTEMPTS) {
            long timeSinceLastAttempt = System.currentTimeMillis() - lastFailedAttemptTime;
            return timeSinceLastAttempt < LOCKOUT_DURATION_MS;
        }
        return false;
    }
    
    public static long getRemainingLockoutTime(long lastFailedAttemptTime) {
        long timeSinceLastAttempt = System.currentTimeMillis() - lastFailedAttemptTime;
        if (timeSinceLastAttempt < LOCKOUT_DURATION_MS) {
            return LOCKOUT_DURATION_MS - timeSinceLastAttempt;
        }
        return 0;
    }

    public static boolean verify(String plainPassword, String hashedPassword) {
        ValidationResponse ppResponse = ValidationUtil.validateString(plainPassword, PASSWORD);
        ValidationResponse hpResponse = ValidationUtil.validateString(hashedPassword, HASED_PASSWORD);
        
        if (!ppResponse.isValid()) {
            throw new IllegalArgumentException(ppResponse.getErrorMessage());
        }
        if (!hpResponse.isValid()) {
            throw new IllegalArgumentException(hpResponse.getErrorMessage());
        }
        
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
