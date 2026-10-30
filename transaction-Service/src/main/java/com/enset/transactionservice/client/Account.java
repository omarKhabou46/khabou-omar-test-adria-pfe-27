package com.enset.transactionservice.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Account {
    private String id;
    private AccountStatus status;
    private String currency;
    private double balance;
}
