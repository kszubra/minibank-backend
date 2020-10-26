package com.kszu.minibank.accounts.server.api.snapshot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountSnapshot {

    private Long id;

    private String accountNumber;

    private String currency;
    
    private String type;

    private BigDecimal availableFunds;

    private BigDecimal reservedFunds;
}
