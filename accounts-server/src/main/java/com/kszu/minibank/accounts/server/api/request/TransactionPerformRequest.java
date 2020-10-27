package com.kszu.minibank.accounts.server.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionPerformRequest {

    private Long transactionId;

    private String chargedAccountNumber;

    private String creditedAccountNumber;

    private BigDecimal value;
}
