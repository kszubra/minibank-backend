package com.kszu.minibank.cards.server.service.interfaces;

import com.kszu.minibank.cards.server.api.response.AccountExistsResponse;

public interface AccountsProvider {
    public AccountExistsResponse getAccountExists(Long accountId);
}
