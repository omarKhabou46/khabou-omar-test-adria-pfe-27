package com.enset.transactionservice.client;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Account {
    private String id;
    private AccountStatus status;
    private String currency;
    private double balance;
}
