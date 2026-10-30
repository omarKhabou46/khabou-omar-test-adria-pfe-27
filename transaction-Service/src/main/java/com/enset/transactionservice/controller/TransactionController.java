package com.enset.transactionservice.controller;

import com.enset.transactionservice.client.Account;
import com.enset.transactionservice.dto.TransactionRequestDTO;
import com.enset.transactionservice.dto.TransactionResponseDTO;
import com.enset.transactionservice.entity.Transaction;
import com.enset.transactionservice.execption.TransactionNotFoundException;
import com.enset.transactionservice.service.ITransctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-service")
@RequiredArgsConstructor
public class TransactionController {

    private final ITransctionService transctionService;


    @GetMapping("{accountId}")
    public ResponseEntity<List<TransactionResponseDTO>> getOperationsByAccountId(@PathVariable String accountId) {
        return new ResponseEntity<>(transctionService.getOperationsByAccountId(accountId), HttpStatus.OK);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<TransactionResponseDTO> getTransactionById(String id) {
        return new ResponseEntity<>(transctionService.getTransactionById(id),HttpStatus.OK);
    }

    @PostMapping("/credit")
    public void credit(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        transctionService.credit(transactionRequestDTO);

    }

    @PostMapping("/debit")
    public void debit(TransactionRequestDTO requestDTO) {
       transctionService.debit(requestDTO);
    }

}
