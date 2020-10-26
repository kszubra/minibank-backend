package com.kszu.minibank.transactions.server.api.snapshot;

import com.kszu.minibank.transactions.server.api.enumeration.TransactionCurrency;
import com.kszu.minibank.transactions.server.api.enumeration.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TransactionSnapshot {

    private Long transactionId;

    private Long userId;

    private String chargedAccount;

    private String creditedAccount;

    private String title;

    private BigDecimal value;

    private TransactionStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime lastStatusChangeAt;

    private String additionalInfo;

    private TransactionCurrency currency;
}
