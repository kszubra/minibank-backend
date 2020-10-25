package com.kszu.minibank.accounts.server.service.interfaces;

import com.kszu.minibank.accounts.server.api.request.AccountCreateRequest;
import com.kszu.minibank.accounts.server.api.response.UserAccountsResponse;
import com.kszu.minibank.accounts.server.api.snapshot.AccountSnapshot;

public interface AccountService {

    Long createAccount(AccountCreateRequest request);

    AccountSnapshot getAccountSnapshot(Long accountId);

    UserAccountsResponse getUserAccounts(Long userId);
}
