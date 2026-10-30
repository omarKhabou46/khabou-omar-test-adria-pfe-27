package com.enset.transactionservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String accountId;
    private BigDecimal amount;
    private String currency;
    private String merchantCategory;
    private String country;
    @CreationTimestamp
    private Instant createdAt;
}
