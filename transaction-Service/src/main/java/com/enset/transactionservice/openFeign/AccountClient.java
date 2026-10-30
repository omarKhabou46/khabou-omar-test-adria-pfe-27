package com.enset.transactionservice.openFeign;

import com.enset.transactionservice.client.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-service", url = "http://localhost:8081/api/account-service")
public interface AccountClient {
    @GetMapping("/{id}")
    Account getAccountById(@PathVariable(name = "id") String accountId);

    @PutMapping
    Account updateAccount(@RequestBody Account account);
}
