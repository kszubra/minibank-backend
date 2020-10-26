package com.kszu.minibank.transactions.server.service;

import com.kszu.minibank.transactions.server.api.enumeration.TransactionStatus;
import com.kszu.minibank.transactions.server.api.request.TransactionCreateRequest;
import com.kszu.minibank.transactions.server.api.snapshot.TransactionSnapshot;
import com.kszu.minibank.transactions.server.domain.model.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper {

    public Transaction mapToTransaction(TransactionCreateRequest request) {
        return Transaction.builder()
                .chargedAccount(request.getChargedAccount())
                .currency(request.getCurrency())
                .creditedAccount(request.getCreditedAccount())
                .lastStatusChangeAt(LocalDateTime.now())
                .status(TransactionStatus.REQUESTED)
                .title(request.getTitle())
                .userId(request.getUserId())
                .value(request.getValue())
                .build();
    }

    public TransactionSnapshot mapToSnapshot(Transaction transaction) {
        return TransactionSnapshot.builder()
                .transactionId(transaction.getTransactionId())
                .chargedAccount(transaction.getChargedAccount())
                .createdAt(transaction.getCreatedAt())
                .creditedAccount(transaction.getCreditedAccount())
                .lastStatusChangeAt(transaction.getLastStatusChangeAt())
                .status(transaction.getStatus())
                .title(transaction.getTitle())
                .userId(transaction.getUserId())
                .value(transaction.getValue())
                .currency(transaction.getCurrency())
                .additionalInfo(transaction.getAdditionalInfo())
                .build();
    }
}
