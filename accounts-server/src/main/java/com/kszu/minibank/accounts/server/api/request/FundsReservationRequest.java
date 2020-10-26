package com.kszu.minibank.accounts.server.api.request;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class FundsReservationRequest {
    @NotBlank
    private String chargedAccountNumber;

    @Min(1)
    private Long transactionId;

    @DecimalMin(value = "0.01", message = "Minimum value is 0.01")
    private BigDecimal value;
}
