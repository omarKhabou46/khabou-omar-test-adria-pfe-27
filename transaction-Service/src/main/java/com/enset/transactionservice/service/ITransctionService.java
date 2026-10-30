package com.enset.transactionservice.service;

import com.enset.transactionservice.dto.TransactionRequestDTO;
import com.enset.transactionservice.dto.TransactionResponseDTO;
import com.enset.transactionservice.entity.Transaction;

import java.util.List;

public interface ITransctionService {

    List<TransactionResponseDTO> getOperationsByAccountId(String accountId);
    TransactionResponseDTO getTransactionById(String id);

    void credit(TransactionRequestDTO requestDTO);

    void debit(TransactionRequestDTO requestDTO) ;

}
