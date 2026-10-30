package com.enset.accountservice.service;

import com.enset.accountservice.dao.AccountRepository;
import com.enset.accountservice.dto.AccountRequestDTO;
import com.enset.accountservice.dto.AccountResponseDTO;
import com.enset.accountservice.entity.Account;
import com.enset.accountservice.exception.AccountNotFoundException;
import com.enset.accountservice.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    @Override
    public void createAccount(AccountRequestDTO requestDTO) {
      accountRepository.save(mapper.fromDto(requestDTO));
    }

    @Override
    public AccountResponseDTO getAccountById(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("account not found"));
        return mapper.toDto(account);
    }

    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map(mapper::toDto).toList();
    }

    @Override
    public AccountResponseDTO updateAccount(Account account) {
        return mapper.toDto(accountRepository.save(account));
    }
}
