package com.enset.transactionservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class TransactionRequestDTO {
    private String accountId;
    private BigDecimal amount;
    private String currency;
    private String merchantCategory;
    private String country;
}
