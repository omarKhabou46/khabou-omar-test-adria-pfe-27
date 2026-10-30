package com.enset.transactionservice.execption;

public class CurrenciesDoNotMatch extends RuntimeException {
    public CurrenciesDoNotMatch(String message) {
        super(message);
    }
}
