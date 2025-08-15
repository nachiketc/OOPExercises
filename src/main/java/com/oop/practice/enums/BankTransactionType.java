package com.oop.practice.enums;

public enum BankTransactionType {
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal");

    private final String label;

    BankTransactionType(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
