package com.kszu.minibank.cards.server.service;

import com.kszu.minibank.cards.server.service.interfaces.CardCvvGenerator;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimpleCvvGenerator implements CardCvvGenerator {

    @Override
    public String generateCvvNumber() {
        Random random = new Random();
        int result = random.nextInt(999);
        String resultString = String.valueOf(result);
        if(result >=100) {
            return resultString;
        } else if (result >= 10) {
            return String.format("0%s", resultString);
        } else {
            return String.format("00%s", resultString);
        }
    }
}
