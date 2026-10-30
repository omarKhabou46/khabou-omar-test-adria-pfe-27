package com.enset.transactionservice.mcp;

import com.enset.transactionservice.dto.TransactionResponseDTO;
import com.enset.transactionservice.service.ITransctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransactionsMcp {

    private final ITransctionService transctionService;

    @McpTool(description = "Retrieve all transactions associated with a specific bank account using its account ID.")
    public List<TransactionResponseDTO> getTransactionsByAccountId(
            @McpToolParam(description = "The unique identifier of the bank account.") String accountId) {
       return transctionService.getOperationsByAccountId(accountId);
   }

}
