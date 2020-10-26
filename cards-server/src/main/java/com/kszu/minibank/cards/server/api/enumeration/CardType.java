package com.kszu.minibank.cards.server.api.enumeration;

import lombok.Getter;

public enum CardType {
    DEBIT(false),
    CREDIT(true);

    @Getter
    private final boolean allowsCreditedPurchase;

    CardType(boolean allowsCreditedPurchase) {
        this.allowsCreditedPurchase = allowsCreditedPurchase;
    }

}
