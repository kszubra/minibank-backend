package com.kszu.minibank.cards.server.api.request;

import com.kszu.minibank.cards.server.api.enumeration.CardProvider;
import com.kszu.minibank.cards.server.api.enumeration.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CardCreateRequest {

    @NotNull
    @Min(1)
    private Long accountId;

    @NotNull
    private CardProvider cardProvider;

    @NotNull
    private CardType cardType;
}
