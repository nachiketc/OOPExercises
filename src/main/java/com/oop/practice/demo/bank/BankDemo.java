package com.oop.practice.demo.bank;

import com.oop.practice.models.bank.BankAccount;
import java.math.BigDecimal;

/**
 * Demo class for Bank Account operations.
 * Demonstrates account management, transactions, and error handling.
 */
public class BankDemo {
    
    /**
     * Runs the Bank Account demo.
     */
    public static void run() {
        System.out.println("\n===== Starting Bank Account Demo =====");
        
        // Create a new bank account
        BankAccount account = new BankAccount("12345678", "John Doe");
        System.out.println("\n=== Created new bank account ===");
        System.out.printf("Account Holder: %s%nAccount Number: %s%n", 
            account.getHolderName(), account.getAccountNumber());
        
        // Make some deposits
        System.out.println("\n=== Making Deposits ===");
        System.out.println("Depositing $500.75");
        account.depositAmount(new BigDecimal("500.75"));
        System.out.println("Depositing $250.50");
        account.depositAmount(new BigDecimal("250.50"));
        
        // Make a withdrawal
        System.out.println("\n=== Making Withdrawal ===");
        System.out.println("Withdrawing $100.25");
        account.withdrawAmount(new BigDecimal("100.25"));
        
        // Try to withdraw more than balance
        System.out.println("\n=== Testing Insufficient Funds ===");
        System.out.println("Attempting to withdraw $1000.00 (more than balance)");
        account.withdrawAmount(new BigDecimal("1000.00"));
        
        // Test invalid transactions
        System.out.println("\n=== Testing Invalid Transactions ===");
        System.out.println("Attempting to deposit negative amount: -$50.00");
        account.depositAmount(new BigDecimal("-50.00"));
        
        System.out.println("Attempting to withdraw negative amount: -$20.00");
        account.withdrawAmount(new BigDecimal("-20.00"));
        
        // Show final state
        System.out.println("\n=== Final Account Summary ===");
        System.out.printf("Account Holder: %s%n", account.getHolderName());
        System.out.printf("Account Number: %s%n", account.getAccountNumber());
        System.out.printf("Current Balance: $%.2f%n", account.getBalance());
        
        System.out.println("\n=== Transaction History ===");
        System.out.println(account.getFormattedTransactionHistory());
    }
    
    public static void main(String[] args) {
        run();
    }
}
