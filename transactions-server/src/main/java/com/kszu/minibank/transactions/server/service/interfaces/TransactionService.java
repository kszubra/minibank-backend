package com.kszu.minibank.transactions.server.service.interfaces;

import com.kszu.minibank.transactions.server.api.request.TransactionCreateRequest;
import com.kszu.minibank.transactions.server.api.request.TransactionStatusUpdateRequest;
import com.kszu.minibank.transactions.server.api.snapshot.TransactionSnapshot;

public interface TransactionService {

    Long createTransaction(TransactionCreateRequest request);

    TransactionSnapshot getTransactionById(Long id);

    void updateTransactionStatus(TransactionStatusUpdateRequest request);
}
