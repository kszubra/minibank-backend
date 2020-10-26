package com.kszu.minibank.transactions.server.api.request;

import com.kszu.minibank.transactions.server.api.enumeration.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionStatusUpdateRequest {

    private Long transactionId;

    private TransactionStatus status;

    private String additionalInfo;
}
