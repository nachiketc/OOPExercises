package com.oop.practice.pojos;

import com.oop.practice.enums.BankTransactionType;

import java.math.BigDecimal;
import java.util.Date;

public class BankTransaction {
    private final BankTransactionType transactionType;
    private final BigDecimal amount;
    private final Date date;

    public BankTransaction(BankTransactionType transactionType, BigDecimal amount, Date date) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
    }

    public static BankTransaction deposit(BigDecimal amount){
        return new BankTransaction(BankTransactionType.DEPOSIT,amount,new Date());
    }

    public static BankTransaction withdrawal(BigDecimal amount){
        return new BankTransaction(BankTransactionType.WITHDRAWAL,amount,new Date());
    }

    public String getTransaction() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(transactionType.getLabel()).append(" : Rs. ").append(amount)
                .append(" on ").append(date).append("\n");
        return stringBuilder.toString();
    }

    public BankTransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
