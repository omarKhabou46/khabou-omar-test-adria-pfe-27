package com.enset.transactionservice.openFeign;

import com.enset.transactionservice.client.Account;
import com.enset.transactionservice.client.AccountStatus;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-service", url = "http://localhost:8081/api/account-service")
public interface AccountClient {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "account-service", fallbackMethod = "getDefaultAccount")
    Account getAccountById(@PathVariable(name = "id") String accountId);


    default Account getDefaultAccount() {
        return Account.builder().id(null).status(AccountStatus.BLOCKED).currency("not defined").balance(-200).build();
    }


    @PutMapping
    Account updateAccount(@RequestBody Account account);
}
