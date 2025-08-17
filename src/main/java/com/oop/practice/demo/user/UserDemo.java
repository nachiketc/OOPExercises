package com.oop.practice.demo.user;

import com.oop.practice.models.user.User;
import com.oop.practice.pojos.LoginAttempt;

import java.util.List;

/**
 * Demo class to demonstrate user authentication functionality.
 */
public class UserDemo {
    
    /**
     * Runs the user authentication demo with predefined test cases.
     */
    public static void run() {
        System.out.println("=== User Authentication Demo ===\n");
        
        // Create a test user
        String username = "testuser";
        String password = "Test@123";
        System.out.println("Creating user with username: " + username + " and password: " + password);
        User user = new User(username, password);
        System.out.println("User account created successfully!\n");
        
        // Test 1: Successful login
        System.out.println("Test 1: Successful login");
        LoginAttempt attempt1 = user.login(username, password);
        printLoginAttempt(attempt1);
        printLoginStatus(user);
        
        // Test 2: Failed login (wrong password)
        System.out.println("\nTest 2: Failed login (wrong password)");
        LoginAttempt attempt2 = user.login(username, "wrongpassword");
        printLoginAttempt(attempt2);
        
        // Test 3: Failed login (wrong username)
        System.out.println("\nTest 3: Failed login (wrong username)");
        LoginAttempt attempt3 = user.login("nonexistent", password);
        printLoginAttempt(attempt3);
        
        // Test 4: Logout
        System.out.println("\nTest 4: Logout");
        user.logout();
        printLoginStatus(user);
        
        // Test 5: View login attempts
        System.out.println("\nTest 5: View all login attempts");
        List<LoginAttempt> attempts = user.getLoginAttempts();
        for (int i = 0; i < attempts.size(); i++) {
            System.out.printf("Attempt %d: %s - %s%n", 
                i + 1, 
                attempts.get(i).getLoginTime(),
                attempts.get(i).isLoginSuccess() ? "SUCCESS" : "FAILED: " + attempts.get(i).getErrorMessage()
            );
        }
        
        System.out.println("\n=== User Authentication Demo Ended ===");
    }
    
    private static void printLoginAttempt(LoginAttempt attempt) {
        System.out.println("Login " + (attempt.isLoginSuccess() ? "successful!" : "failed: " + attempt.getErrorMessage()));
    }
    
    private static void printLoginStatus(User user) {
        System.out.println("Login status: " + (user.isLoggedIn() ? "LOGGED IN" : "LOGGED OUT"));
        if (user.isLoggedIn()) {
            System.out.println("Session ID: " + user.getSessionId());
        }
    }

}
