package com.oop.practice.models.bank;

import com.oop.practice.pojos.BankTransaction;
import com.oop.practice.pojos.ValidationResponse;
import com.oop.practice.utils.ValidationUtil;

import java.math.BigDecimal;
import java.util.*;

import static com.oop.practice.constants.BankConstants.*;

/**
 * Represents a bank account with basic operations like deposit and withdraw.
 */
public class BankAccount {
    private final String accountNumber;
    private final String holderName;
    private BigDecimal balance;
    private final List<BankTransaction> transactionHistory;

    public BankAccount(String accountNumber, String holderName) {
        ValidationUtil.validateStringAndThrow(accountNumber,ACCOUNT_NUMBER);
        ValidationUtil.validateStringAndThrow(holderName, HOLDER_NAME);
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
        ValidationResponse validationResponse = ValidationUtil.validatePositiveBD(amount,AMOUNT);
        if (!validationResponse.isValid()){
            System.out.println(validationResponse.getErrorMessage());
        } else {
            balance = balance.add(amount);
            transactionHistory.add(BankTransaction.deposit(amount));
        }

    }

    public void withdrawAmount(BigDecimal amount) {
        ValidationResponse amountResponse = ValidationUtil.validatePositiveBD(amount,AMOUNT);
        ValidationResponse compareResponse = ValidationUtil.validateBDGreaterThanBD(balance,amount);
        if (!amountResponse.isValid()){
            System.out.println(amountResponse.getErrorMessage());
        } else if (!compareResponse.isValid()) {
            System.out.println("Insufficient funds for withdrawal");
        } else {
            balance = balance.subtract(amount);
            transactionHistory.add(BankTransaction.withdrawal(amount));
        }
    }

}
