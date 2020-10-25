package com.kszu.minibank.accounts.server.service;

import com.kszu.minibank.accounts.server.service.interfaces.AccountNumberGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimpleAccountNumberGenerator implements AccountNumberGenerator {

    @Override
    public String generateAccountNumber() {
        return UUID.randomUUID().toString();
    }
}
