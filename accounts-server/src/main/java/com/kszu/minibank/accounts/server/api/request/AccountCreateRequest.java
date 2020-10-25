package com.kszu.minibank.accounts.server.api.request;

import com.kszu.minibank.accounts.server.api.enumeration.AccountCurrency;
import com.kszu.minibank.accounts.server.api.enumeration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AccountCreateRequest {
    
    @NotNull
    private AccountCurrency currency;
    
    @NotNull
    private AccountType type;

    @Min(1)
    private Long customerId;
}
