package com.kszu.minibank.cards.server.service.interfaces;

import com.kszu.minibank.cards.server.api.request.CardCreateRequest;
import com.kszu.minibank.cards.server.api.response.UserCardsResponse;

public interface CardService {

    Long createCard(CardCreateRequest request);

    UserCardsResponse getCustomerCards(Long customerId);
}
