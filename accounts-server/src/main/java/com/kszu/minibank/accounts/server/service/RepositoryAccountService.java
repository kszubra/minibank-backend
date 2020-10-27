package com.kszu.minibank.accounts.server.service;

import com.kszu.minibank.accounts.server.api.request.AccountCreateRequest;
import com.kszu.minibank.accounts.server.api.request.FundsReservationRequest;
import com.kszu.minibank.accounts.server.api.request.TransactionPerformRequest;
import com.kszu.minibank.accounts.server.api.response.AccountExistsResponse;
import com.kszu.minibank.accounts.server.api.response.FundsReservationResponse;
import com.kszu.minibank.accounts.server.api.response.TransactionResultResponse;
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
import java.util.Objects;
import java.util.Optional;
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
    @Transactional
    public FundsReservationResponse reserveFunds(FundsReservationRequest request) {
        log.debug("Reserving funds at account number: {} for transaction: {}", request.getChargedAccountNumber(), request.getTransactionId());
        Optional<Account> account = accountRepository.findByAccountNumber(request.getChargedAccountNumber());
        Long transactionId = request.getTransactionId();
        if(account.isEmpty()) {
            return FundsReservationResponse.failure(transactionId, "Account not found");
        } else {
            Account acc = account.get();
            int comparison = acc.getAvailableFunds().compareTo(request.getValue());
            if(comparison > -1) {
                acc.reserveFunds(request.getValue());
                return FundsReservationResponse.success(transactionId);
            } else {
                return FundsReservationResponse.failure(transactionId, "Insufficient funds");
            }
        }
    }

    @Override
    @Transactional
    public TransactionResultResponse performTransaction(TransactionPerformRequest request) {
        log.debug("Performing transaction with id: {}", request.getTransactionId());

        accountRepository.findByAccountNumber(request.getChargedAccountNumber())
                .ifPresentOrElse(account -> account.chargeAccount(request.getValue()),
                        () -> TransactionResultResponse.failed(request.getTransactionId(), "Charged account not found"));

        accountRepository.findByAccountNumber(request.getCreditedAccountNumber())
                .ifPresentOrElse(account -> account.creditAccount(request.getValue()),
                        () -> sendRequestToElixirSession(request));

        return TransactionResultResponse.success(request.getTransactionId());

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

    @Override
    public AccountExistsResponse getAccountExists(Long accountId) {
        Account account = accountRepository.findById(accountId).orElse(null);
        if(Objects.nonNull(account)) {
            return AccountExistsResponse.exists(accountId, account.getUserId());
        }
        return AccountExistsResponse.notExists(accountId);
    }

    private Account getById(Long id) {
        return accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    void sendRequestToElixirSession(TransactionPerformRequest request) {
        log.info("Mocked requesting to credit account: {} with value: {} in ELIXIR session", request.getCreditedAccountNumber(), request.getValue());
    }
}
