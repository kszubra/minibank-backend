package com.kszu.minibank.accounts.server.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FundsReservationResponse {

    private Long transactionId;

    private Boolean success;

    private String additionalInfo;

    public static FundsReservationResponse success(Long transactionId) {
        return new FundsReservationResponse(transactionId, true, null);
    }

    public static FundsReservationResponse failure(Long transactionId, String reason) {
        return new FundsReservationResponse(transactionId, false, reason);
    }
}
