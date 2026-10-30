package com.enset.transactionservice.execption;

public class SoldeInsuffisant extends RuntimeException {
    public SoldeInsuffisant(String message) {
        super(message);
    }
}
