package com.kszu.minibank.accounts.server.service;

import com.kszu.minibank.accounts.server.api.request.AccountCreateRequest;
import com.kszu.minibank.accounts.server.api.response.AccountExistsResponse;
import com.kszu.minibank.accounts.server.api.response.UserAccountsResponse;
import com.kszu.minibank.accounts.server.api.snapshot.AccountSnapshot;
import com.kszu.minibank.accounts.server.service.interfaces.AccountApiService;
import com.kszu.minibank.accounts.server.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultAccountApiService implements AccountApiService {

    private final AccountService accountService;


    @Override
    public Long createAccount(AccountCreateRequest request) {
        return accountService.createAccount(request);
    }

    @Override
    public AccountSnapshot getAccountSnapshot(Long accountId) {
        return accountService.getAccountSnapshot(accountId);
    }

    @Override
    public UserAccountsResponse getUserAccounts(Long userId) {
        return accountService.getUserAccounts(userId);
    }

    @Override
    public AccountExistsResponse getAccountExists(Long accountId) {
        return accountService.getAccountExists(accountId);
    }
}
