package com.kszu.minibank.cards.server.service;

import com.kszu.minibank.cards.server.service.interfaces.CardNumberGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimpleCardNumberGenerator implements CardNumberGenerator {

    @Override
    public String generateCardNumber() {
        return UUID.randomUUID().toString();
    }
}
