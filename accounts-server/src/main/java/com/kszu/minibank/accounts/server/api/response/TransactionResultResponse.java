package com.kszu.minibank.accounts.server.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionResultResponse {

    private Long transactionId;

    private Boolean success;

    private String additionalInfo;

    public static TransactionResultResponse failed(Long id, String info) {
        return new TransactionResultResponse(id, false, info);
    }

    public static TransactionResultResponse success(Long id) {
        return new TransactionResultResponse(id, true, null);
    }
}
