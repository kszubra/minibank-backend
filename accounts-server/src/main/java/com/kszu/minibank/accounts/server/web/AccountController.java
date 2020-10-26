package com.kszu.minibank.accounts.server.web;

import com.kszu.minibank.accounts.server.api.request.AccountCreateRequest;
import com.kszu.minibank.accounts.server.api.response.AccountExistsResponse;
import com.kszu.minibank.accounts.server.api.response.UserAccountsResponse;
import com.kszu.minibank.accounts.server.api.snapshot.AccountSnapshot;
import com.kszu.minibank.accounts.server.service.interfaces.AccountApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountApiService accountService;

    @PostMapping
    //TODO get user id from token
    public Long createAccount(@RequestBody @Valid AccountCreateRequest request) {
        return accountService.createAccount(request);
    }

    @GetMapping
    //TODO get from token
    public UserAccountsResponse getUserAccounts(@RequestParam Long customerId) {
        return accountService.getUserAccounts(customerId);
    }

    @GetMapping("/{id}")
    public AccountSnapshot getBankAccount(@PathVariable Long id) {
        return accountService.getAccountSnapshot(id);
    }

    @GetMapping("/exists/{id}")
    public AccountExistsResponse getAccountExists(@PathVariable Long id) {
        return accountService.getAccountExists(id);
    }
}
