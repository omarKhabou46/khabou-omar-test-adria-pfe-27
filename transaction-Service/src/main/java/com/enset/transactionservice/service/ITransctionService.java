package com.enset.transactionservice.service;

import com.enset.transactionservice.dto.TransactionResponseDTO;

import java.util.List;

public interface ITransctionService {

    List<TransactionResponseDTO> getOperationsByAccountId(String accountId);
    TransactionResponseDTO getTransactionById(String id);

    void credit(String accountId, double amount, String description);

    void transfer(String accountIdSource, String accountIdDestination, double amount) ;

    void debit(String accountId, double amount, String description) ;

}
