package com.enset.accountservice.service;

import com.enset.accountservice.dto.AccountRequestDTO;
import com.enset.accountservice.dto.AccountResponseDTO;
import com.enset.accountservice.entity.Account;

import java.util.List;

public interface IAccountService {
    void createAccount(AccountRequestDTO requestDTO);
    Account getAccountById(String id);
    List<AccountResponseDTO> getAllAccounts();
}
