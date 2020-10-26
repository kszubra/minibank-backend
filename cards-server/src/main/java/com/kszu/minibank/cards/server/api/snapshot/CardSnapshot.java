package com.kszu.minibank.cards.server.api.snapshot;

import com.kszu.minibank.cards.server.api.enumeration.CardProvider;
import com.kszu.minibank.cards.server.api.enumeration.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CardSnapshot {

    private Long cardId;

    private String cardNumber;

    private Long account;

    private CardType cardType;

    private CardProvider cardProvider;

    private LocalDate expirationDate;

    private String cvvNumber;

    private Boolean isActive;
}
