package com.kszu.minibank.transactions.server.web;

import com.kszu.minibank.transactions.server.api.request.TransactionCreateRequest;
import com.kszu.minibank.transactions.server.api.request.TransactionStatusUpdateRequest;
import com.kszu.minibank.transactions.server.api.snapshot.TransactionSnapshot;
import com.kszu.minibank.transactions.server.service.interfaces.TransactionApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionApiService apiService;

    @PostMapping
    public Long createTransaction(@RequestBody @Valid TransactionCreateRequest request) {
        return apiService.createTransaction(request);
    }

    @GetMapping("/{transactionId}")
    public TransactionSnapshot getTransactionById(@PathVariable Long transactionId) {
        return apiService.getTransactionById(transactionId);
    }

    @PutMapping
    public void updateTransactionStatus(@RequestBody @Valid TransactionStatusUpdateRequest request) {
        apiService.updateTransactionStatus(request);
    }
}
