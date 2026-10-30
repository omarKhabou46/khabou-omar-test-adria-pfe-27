package com.enset.accountservice.controller;

import com.enset.accountservice.dto.AccountRequestDTO;
import com.enset.accountservice.dto.AccountResponseDTO;
import com.enset.accountservice.entity.Account;
import com.enset.accountservice.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-service")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Void> createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        accountService.createAccount(accountRequestDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountResponseDTO> getAccount(@PathVariable String id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AccountResponseDTO> updateAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }


}

