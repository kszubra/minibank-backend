package com.kszu.minibank.accounts.server.service;

import com.kszu.minibank.accounts.server.api.request.AccountCreateRequest;
import com.kszu.minibank.accounts.server.api.snapshot.AccountSnapshot;
import com.kszu.minibank.accounts.server.domain.model.Account;
import com.kszu.minibank.accounts.server.service.interfaces.AccountNumberGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@AllArgsConstructor
public class AccountMapper {
    private final AccountNumberGenerator accountNumberGenerator;

    public Account mapToEntity(AccountCreateRequest request) {
        return Account.builder()
                .availableFunds(BigDecimal.ZERO)
                .currency(request.getCurrency())
                .type(request.getType())
                .userId(request.getCustomerId())
                .accountNumber(accountNumberGenerator.generateAccountNumber())
                .build();
    }

    public AccountSnapshot mapToSnapshot(Account account) {
        return AccountSnapshot.builder()
                .id(account.getAccountId())
                .availableFunds(account.getAvailableFunds().setScale(2, RoundingMode.HALF_EVEN))
                .currency(account.getCurrency().toString())
                .type(account.getType().toString())
                .accountNumber(account.getAccountNumber())
                .build();
    }
}
