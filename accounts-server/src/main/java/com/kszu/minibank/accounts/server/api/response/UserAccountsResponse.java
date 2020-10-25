package com.kszu.minibank.accounts.server.api.response;

import com.kszu.minibank.accounts.server.api.snapshot.AccountSnapshot;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserAccountsResponse {
    private List<AccountSnapshot> accounts;
}
