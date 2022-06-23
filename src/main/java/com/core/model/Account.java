package com.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String accountId;
    private String customerId;
    private String accountType;
    private String balance;
    private String initialDeposit;
}
