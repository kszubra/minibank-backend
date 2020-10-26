package com.kszu.minibank.transactions.server.service;

import com.kszu.minibank.transactions.server.api.enumeration.TransactionStatus;
import com.kszu.minibank.transactions.server.api.request.TransactionCreateRequest;
import com.kszu.minibank.transactions.server.api.request.TransactionStatusUpdateRequest;
import com.kszu.minibank.transactions.server.api.snapshot.TransactionSnapshot;
import com.kszu.minibank.transactions.server.service.interfaces.TransactionApiService;
import com.kszu.minibank.transactions.server.service.interfaces.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultTransactionApiService implements TransactionApiService {

    private final TransactionService transactionService;

    @Override
    public Long createTransaction(TransactionCreateRequest request) {
        return transactionService.createTransaction(request);
    }

    @Override
    public TransactionSnapshot getTransactionById(Long id) {
        return transactionService.getTransactionById(id);
    }

    @Override
    public void updateTransactionStatus(TransactionStatusUpdateRequest request) {
        transactionService.updateTransactionStatus(request);
    }
}
