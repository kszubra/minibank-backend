package com.kszu.minibank.transactions.server.api.request;

import com.kszu.minibank.transactions.server.api.enumeration.TransactionCurrency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TransactionCreateRequest {

    @NotBlank
    private String chargedAccount;

    @NotBlank
    private String creditedAccount;

    @NotBlank
    private String title;

    @DecimalMin(value = "0.01")
    private BigDecimal value;

    @Setter
    private Long userId;

    @NotNull
    private TransactionCurrency currency;
}
