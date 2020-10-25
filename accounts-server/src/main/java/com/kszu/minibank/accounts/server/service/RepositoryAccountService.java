package com.kszu.minibank.accounts.server.service;

import com.kszu.minibank.accounts.server.api.request.AccountCreateRequest;
import com.kszu.minibank.accounts.server.api.response.UserAccountsResponse;
import com.kszu.minibank.accounts.server.api.snapshot.AccountSnapshot;
import com.kszu.minibank.accounts.server.domain.model.Account;
import com.kszu.minibank.accounts.server.domain.repository.AccountRepository;
import com.kszu.minibank.accounts.server.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class RepositoryAccountService implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    @Override
    @Transactional
    public Long createAccount(AccountCreateRequest request) {
        log.debug("Creating new bank account");

        Long id = accountRepository.save(mapper.mapToEntity(request)).getAccountId();

        log.info("Added bank account with id: {}", id);

        return id;
    }

    @Override
    public AccountSnapshot getAccountSnapshot(Long accountId) {
        log.debug("Getting account snapshot with id: {}", accountId);
        return mapper.mapToSnapshot(getById(accountId));
    }

    @Override
    public UserAccountsResponse getUserAccounts(Long userId) {
        log.debug("Getting accounts for user: {}", userId);
        List<AccountSnapshot> accounts = accountRepository.findAllByUserId(userId).stream()
                .map(mapper::mapToSnapshot)
                .collect(Collectors.toList());

        return new UserAccountsResponse(accounts);
    }

    private Account getById(Long id) {
        return accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
