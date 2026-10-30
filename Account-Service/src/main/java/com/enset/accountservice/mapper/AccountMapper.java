package com.enset.accountservice.mapper;

import com.enset.accountservice.dto.AccountRequestDTO;
import com.enset.accountservice.dto.AccountResponseDTO;
import com.enset.accountservice.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account fromDto(AccountRequestDTO accountRequestDTO);
    AccountResponseDTO toDto(Account account);
}
