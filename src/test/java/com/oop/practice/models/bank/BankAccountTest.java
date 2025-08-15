package com.oop.practice.models.bank;

import com.oop.practice.enums.BankTransactionType;
import com.oop.practice.pojos.BankTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private static final String ACCOUNT_NUMBER = "12345678";
    private static final String HOLDER_NAME = "John Doe";

    @BeforeEach
    void setUp() {
        account = new BankAccount(ACCOUNT_NUMBER, HOLDER_NAME);
    }

    @Test
    void testInitialBalance() {
        assertEquals(BigDecimal.ZERO, account.getBalance());
    }

    @Test
    void testDeposit() {
        account.depositAmount(new BigDecimal("100.50"));
        assertEquals(0, new BigDecimal("100.50").compareTo(account.getBalance()));
    }

    @Test
    void testWithdraw() {
        account.depositAmount(new BigDecimal("200.00"));
        account.withdrawAmount(new BigDecimal("50.25"));
        assertEquals(0, new BigDecimal("149.75").compareTo(account.getBalance()));
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.depositAmount(new BigDecimal("50.00"));
        account.withdrawAmount(new BigDecimal("100.00")); // Should log warning
        assertEquals(0, new BigDecimal("50.00").compareTo(account.getBalance()));
    }

    @Test
    void testTransactionHistory() {
        account.depositAmount(new BigDecimal("100.00"));
        account.withdrawAmount(new BigDecimal("30.00"));

        List<BankTransaction> transactions = account.getTransactionHistory();
        assertEquals(2, transactions.size());
        assertEquals(BankTransactionType.DEPOSIT, transactions.get(0).getTransactionType());
        assertEquals(BankTransactionType.WITHDRAWAL, transactions.get(1).getTransactionType());
    }

    @Test
    void testNegativeDeposit() {
        account.depositAmount(new BigDecimal("-10.00")); // Should log warning
        assertEquals(0, BigDecimal.ZERO.compareTo(account.getBalance()));
    }

    @Test
    void testNegativeWithdraw() {
        account.depositAmount(new BigDecimal("100.00"));
        account.withdrawAmount(new BigDecimal("-10.00")); // Should log warning
        assertEquals(0, new BigDecimal("100.00").compareTo(account.getBalance()));
    }

    @Test
    void testGetAccountDetails() {
        assertEquals(ACCOUNT_NUMBER, account.getAccountNumber());
        assertEquals(HOLDER_NAME, account.getHolderName());
    }
}