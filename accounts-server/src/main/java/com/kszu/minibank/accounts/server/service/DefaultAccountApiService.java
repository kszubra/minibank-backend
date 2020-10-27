package com.kszu.minibank.accounts.server.service;

import com.kszu.minibank.accounts.server.api.request.AccountCreateRequest;
import com.kszu.minibank.accounts.server.api.request.FundsReservationRequest;
import com.kszu.minibank.accounts.server.api.request.TransactionPerformRequest;
import com.kszu.minibank.accounts.server.api.response.AccountExistsResponse;
import com.kszu.minibank.accounts.server.api.response.FundsReservationResponse;
import com.kszu.minibank.accounts.server.api.response.TransactionResultResponse;
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

    @Override
    public FundsReservationResponse reserveFunds(FundsReservationRequest request) {
        return accountService.reserveFunds(request);
    }

    @Override
    public TransactionResultResponse performTransaction(TransactionPerformRequest request) {
        return accountService.performTransaction(request);
    }
}
