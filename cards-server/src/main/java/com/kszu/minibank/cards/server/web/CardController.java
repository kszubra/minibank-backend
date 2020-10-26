package com.kszu.minibank.cards.server.web;

import com.kszu.minibank.cards.server.api.request.CardCreateRequest;
import com.kszu.minibank.cards.server.api.response.UserCardsResponse;
import com.kszu.minibank.cards.server.service.interfaces.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public Long createCard(@RequestBody @Valid CardCreateRequest request) {
        return cardService.createCard(request);
    }

    @GetMapping
    public UserCardsResponse getCustomerCards(@RequestParam Long customerId) {
        return cardService.getCustomerCards(customerId);
    }

}
