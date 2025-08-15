package com.oop.practice.models.bank;

import com.oop.practice.enums.BankTransactionType;
import com.oop.practice.pojos.BankTransaction;

import java.math.BigDecimal;
import java.util.*;

/**
 * Represents a bank account with basic operations like deposit and withdraw.
 */
public class BankAccount {
    private final String accountNumber;
    private final String holderName;
    private BigDecimal balance;
    private final List<BankTransaction> transactionHistory;

    public BankAccount(String accountNumber, String holderName) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (holderName == null || holderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Holder name cannot be null or empty");
        }
        
        this.accountNumber = accountNumber.trim();
        this.holderName = holderName.trim();
        this.balance = BigDecimal.ZERO;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getFormattedTransactionHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transaction History:\n");
        transactionHistory.forEach(transaction -> stringBuilder.append(transaction.getTransaction()));
        return stringBuilder.toString();
    }

    public List<BankTransaction> getTransactionHistory(){
        return Collections.unmodifiableList(transactionHistory);
    }

    public void depositAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Deposit amount must be positive");
        } else {
            balance = balance.add(amount);
            transactionHistory.add(new BankTransaction(BankTransactionType.DEPOSIT, amount, new Date()));
        }
    }

    public void withdrawAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Withdrawal amount must be positive");
        } else if (balance.compareTo(amount) < 0) {
            System.out.println("Insufficient funds for withdrawal");
        } else {
            balance = balance.subtract(amount);
            transactionHistory.add(new BankTransaction(BankTransactionType.WITHDRAWAL, amount, new Date()));
        }
    }
}
