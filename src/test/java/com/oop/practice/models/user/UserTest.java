package com.oop.practice.models.user;

import com.oop.practice.pojos.LoginAttempt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "SecurePass123!";
    private static final String WRONG_USERNAME = "wronguser";
    private static final String WRONG_PASSWORD = "WrongPass123!";

    @BeforeEach
    void setUp() {
        user = new User(USERNAME, PASSWORD);
    }

    @Test
    void testSuccessfulLogin() {
        // When
        LoginAttempt attempt = user.login(USERNAME, PASSWORD);

        // Then
        assertTrue(attempt.isLoginSuccess(), "Login should be successful with correct credentials");
        assertTrue(user.isLoggedIn(), "User should be logged in after successful login");
        assertNotNull(user.getSessionId(), "Session ID should not be null after login");
        assertFalse(user.getSessionId().isEmpty(), "Session ID should not be empty after login");
    }

    @Test
    void testLoginWithWrongUsername() {
        // When
        LoginAttempt attempt = user.login(WRONG_USERNAME, PASSWORD);

        // Then
        assertFalse(attempt.isLoginSuccess(), "Login should fail with wrong username");
        assertEquals("Username does not match", attempt.getErrorMessage(), 
            "Error message should indicate username mismatch");
        assertFalse(user.isLoggedIn(), "User should not be logged in after failed login");
    }

    @Test
    void testLoginWithWrongPassword() {
        // When
        LoginAttempt attempt = user.login(USERNAME, WRONG_PASSWORD);

        // Then
        assertFalse(attempt.isLoginSuccess(), "Login should fail with wrong password");
        assertEquals("Password is incorrect", attempt.getErrorMessage(),
            "Error message should indicate password is incorrect");
        assertFalse(user.isLoggedIn(), "User should not be logged in after failed login");
    }

    @Test
    void testLoginWhenAlreadyLoggedIn() {
        // Given
        user.login(USERNAME, PASSWORD);
        assertTrue(user.isLoggedIn(), "User should be logged in after first login");

        // When
        LoginAttempt attempt = user.login(USERNAME, PASSWORD);

        // Then
        assertFalse(attempt.isLoginSuccess(), "Second login attempt should fail");
        assertEquals("Already session going on", attempt.getErrorMessage(),
            "Error message should indicate user is already logged in");
    }

    @Test
    void testLogout() {
        // Given
        user.login(USERNAME, PASSWORD);
        assertTrue(user.isLoggedIn(), "User should be logged in before logout");
        String sessionId = user.getSessionId();
        assertNotNull(sessionId, "Session ID should not be null when logged in");

        // When
        user.logout();

        // Then
        assertFalse(user.isLoggedIn(), "User should not be logged in after logout");
        assertTrue(user.getSessionId().isEmpty(), "Session ID should be empty after logout");
    }

    @Test
    void testMultipleLoginAttempts() {
        // When
        LoginAttempt attempt1 = user.login(USERNAME, WRONG_PASSWORD);
        LoginAttempt attempt2 = user.login(USERNAME, WRONG_PASSWORD);
        LoginAttempt attempt3 = user.login(USERNAME, PASSWORD);

        // Then
        assertFalse(attempt1.isLoginSuccess(), "First attempt with wrong password should fail");
        assertFalse(attempt2.isLoginSuccess(), "Second attempt with wrong password should fail");
        assertTrue(attempt3.isLoginSuccess(), "Third attempt with correct password should succeed");
        assertTrue(user.isLoggedIn(), "User should be logged in after successful attempt");
    }
    
    @Test
    void testGetLoginAttempts() {
        // When
        user.login(USERNAME, WRONG_PASSWORD);
        user.login(USERNAME, WRONG_PASSWORD);
        user.login(USERNAME, PASSWORD);
        
        // Then
        List<LoginAttempt> attempts = user.getLoginAttempts();
        assertEquals(3, attempts.size(), "Should track all login attempts");
        assertFalse(attempts.get(0).isLoginSuccess(), "First attempt should be failed");
        assertFalse(attempts.get(1).isLoginSuccess(), "Second attempt should be failed");
        assertTrue(attempts.get(2).isLoginSuccess(), "Third attempt should be successful");
    }

    @Test
    void testNullUsernameInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, PASSWORD));
    }

    @Test
    void testEmptyUsernameInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new User("", PASSWORD));
    }

    @Test
    void testNullPasswordInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new User(USERNAME, null));
    }

    @Test
    void testEmptyPasswordInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new User(USERNAME, ""));
    }

    @Test
    void testNullUsernameInLogin() {
        // When/Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> user.login(null, PASSWORD),
            "Should throw IllegalArgumentException for null username");
        assertTrue(exception.getMessage().contains("cannot be null or empty"), 
            "Error message should indicate username cannot be null");
    }

    @Test
    void testEmptyUsernameInLogin() {
        // When/Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> user.login("", PASSWORD),
            "Should throw IllegalArgumentException for empty username");
        assertTrue(exception.getMessage().contains("cannot be null or empty"),
            "Error message should indicate username cannot be empty");
    }

    @Test
    void testNullPasswordInLogin() {
        // When/Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> user.login(USERNAME, null),
            "Should throw IllegalArgumentException for null password");
        assertTrue(exception.getMessage().contains("cannot be null"),
            "Error message should indicate password cannot be null");
    }

    @Test
    void testEmptyPasswordInLogin() {
        // When/Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> user.login(USERNAME, ""),
            "Should throw IllegalArgumentException for empty password");
        assertTrue(exception.getMessage().contains("cannot be null or empty"),
            "Error message should indicate password cannot be empty");
    }
}
