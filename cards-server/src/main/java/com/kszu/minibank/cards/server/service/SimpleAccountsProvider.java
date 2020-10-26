package com.kszu.minibank.cards.server.service;

import com.kszu.minibank.cards.server.api.response.AccountExistsResponse;
import com.kszu.minibank.cards.server.connector.AccountsConnector;
import com.kszu.minibank.cards.server.service.interfaces.AccountsProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SimpleAccountsProvider implements AccountsProvider {

    private final AccountsConnector connector;

    @Override
    public AccountExistsResponse getAccountExists(Long accountId) {
        return connector.getAccountExists(accountId);
    }
}
