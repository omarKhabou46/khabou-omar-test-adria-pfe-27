package com.enset.transactionservice.service;

import com.enset.transactionservice.client.Account;
import com.enset.transactionservice.dao.TransactionRepo;
import com.enset.transactionservice.dto.TransactionResponseDTO;
import com.enset.transactionservice.entity.Transaction;
import com.enset.transactionservice.execption.TransactionNotFoundException;
import com.enset.transactionservice.mapper.TransactionMapper;
import com.enset.transactionservice.openFeign.AccountClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransctionService {

    private final TransactionRepo transactionRepo;
    private final TransactionMapper mapper;
    private final AccountClient accountClient;

    @Override
    public List<TransactionResponseDTO> getOperationsByAccountId(String accountId) {

        List<Transaction> transactionList = transactionRepo.findAllByAccountId(accountId);
        return transactionList.stream().map(mapper::toDto).toList();
    }

    @Override
    public TransactionResponseDTO getTransactionById(String id) {
        Transaction transaction = transactionRepo.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("transaction not found"));

        return mapper.toDto(transaction);
    }

    @Override
    public void credit(String accountId, double amount, String description) {
        Account account = accountClient.getById(accountId);
        account.setBalance(account.getBalance() - amount);
        Transaction transaction = Transaction.builder()
                .account(account)
                .amount(BigDecimal.valueOf(amount))
                .country("")
                .currency("")
                .merchantCategory("")
                .build();

    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) {

    }

    @Override
    public void debit(String accountId, double amount, String description) {

    }
}
