package com.uitest.model;

public class Account {
    private String accountId;
    private String customerId;
    private String accountType;
    private String balance;
    private String initialDeposit;

    public String getBalance() {
        return balance;
    }

    public Account setBalance(String balance) {
        this.balance = balance;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public Account setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Account setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public Account setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getInitialDeposit() {
        return initialDeposit;
    }

    public Account setInitialDeposit(String initialDeposit) {
        this.initialDeposit = initialDeposit;
        return this;
    }
}
