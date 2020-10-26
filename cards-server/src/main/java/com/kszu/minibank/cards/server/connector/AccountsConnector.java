package com.kszu.minibank.cards.server.connector;

import com.kszu.minibank.cards.server.api.response.AccountExistsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "accounts-server", fallback = AccountsConnectorFallback.class)
public interface AccountsConnector {

    @GetMapping("/accounts/exists/{id}")
    AccountExistsResponse getAccountExists(@PathVariable Long id);
}

@Slf4j
@Component
class AccountsConnectorFallback implements AccountsConnector {

    @Override
    public AccountExistsResponse getAccountExists(Long id) {
        log.warn("Can not check whether account with id: {} exists", id);
        return new AccountExistsResponse(id, null, null);
    }
}
