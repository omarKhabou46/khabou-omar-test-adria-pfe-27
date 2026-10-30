package com.enset.accountservice.service;

import com.enset.accountservice.dao.AccountRepository;
import com.enset.accountservice.dto.AccountRequestDTO;
import com.enset.accountservice.dto.AccountResponseDTO;
import com.enset.accountservice.entity.Account;
import com.enset.accountservice.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    @Override
    public void createAccount(AccountRequestDTO requestDTO) {

    }

    @Override
    public Account getAccountById(String id) {
        return null;
    }

    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        return List.of();
    }
}
