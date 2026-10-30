package com.enset.transactionservice.dto;
import java.math.BigDecimal;
import java.time.Instant;

public class TransactionResponseDTO {
    private String id;
    private BigDecimal amount;
    private String currency;
    private String merchantCategory;
    private String country;
    private Instant createdAt;
}
