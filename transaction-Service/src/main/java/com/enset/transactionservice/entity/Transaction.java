package com.enset.transactionservice.entity;

import com.enset.transactionservice.client.Account;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Builder
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
    @Transient
    private Account account;
}
