package com.enset.accountservice.entity;

import com.enset.accountservice.entity.enumiration.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Enumerated(value = EnumType.STRING)
    private AccountStatus status;
    private String currency;
    private double balance;
}
