package com.kszu.minibank.transactions.server.service;

import com.kszu.minibank.transactions.server.api.request.TransactionCreateRequest;
import com.kszu.minibank.transactions.server.api.request.TransactionStatusUpdateRequest;
import com.kszu.minibank.transactions.server.api.snapshot.TransactionSnapshot;
import com.kszu.minibank.transactions.server.domain.model.Transaction;
import com.kszu.minibank.transactions.server.domain.repository.TransactionRepository;
import com.kszu.minibank.transactions.server.service.interfaces.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class RepositoryTransactionService implements TransactionService {

    private final TransactionMapper mapper;
    private final TransactionRepository repository;

    @Override
    @Transactional
    public Long createTransaction(TransactionCreateRequest request) {
        log.debug("Creating new transaction for: {}", request.getUserId());
        Transaction transaction = mapper.mapToTransaction(request);

        return repository.save(transaction).getTransactionId();
    }

    @Override
    @Transactional
    public void updateTransactionStatus(TransactionStatusUpdateRequest request) {
        log.debug("Setting new status: {} for transaction: {}", request.getStatus(), request.getTransactionId());
        Transaction transaction = findById(request.getTransactionId());
        transaction.updateStatus(request.getStatus());

        log.info("Updated transaction with id: {}", request.getTransactionId());
    }

    @Override
    public TransactionSnapshot getTransactionById(Long id) {
        log.debug("Getting transaction by id: {}", id);
        return mapper.mapToSnapshot(findById(id));
    }

    private Transaction findById(Long id) {
        return  repository.findById(id).orElseThrow(IllegalAccessError::new);
    }
}
