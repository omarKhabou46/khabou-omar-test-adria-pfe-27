package com.enset.transactionservice.mapper;

import com.enset.transactionservice.dto.TransactionRequestDTO;
import com.enset.transactionservice.dto.TransactionResponseDTO;
import com.enset.transactionservice.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionResponseDTO toDto(Transaction transaction);
    TransactionRequestDTO fromTransaction(Transaction transaction);

    Transaction fromDto(TransactionRequestDTO transactionRequestDTO);
}
