package com.enset.transactionservice.openFeign;

import com.enset.transactionservice.client.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountClient {

    public Account getById(String accountId) {
        return new Account();
    }
}
