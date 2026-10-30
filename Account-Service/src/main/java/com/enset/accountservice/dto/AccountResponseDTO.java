package com.enset.accountservice.dto;

import com.enset.accountservice.entity.enumiration.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AccountResponseDTO {
    private String id;
    private AccountStatus status;
    private String currency;
    private double balance;
}
