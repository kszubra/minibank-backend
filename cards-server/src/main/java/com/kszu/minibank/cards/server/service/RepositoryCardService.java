package com.kszu.minibank.cards.server.service;

import com.kszu.minibank.cards.server.api.request.CardCreateRequest;
import com.kszu.minibank.cards.server.api.response.AccountExistsResponse;
import com.kszu.minibank.cards.server.api.response.UserCardsResponse;
import com.kszu.minibank.cards.server.domain.model.Card;
import com.kszu.minibank.cards.server.domain.repository.CardRepository;
import com.kszu.minibank.cards.server.service.interfaces.AccountsProvider;
import com.kszu.minibank.cards.server.service.interfaces.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RepositoryCardService implements CardService {

    private final CardMapper mapper;
    private final CardRepository repository;
    private final AccountsProvider accountsProvider;

    @Override
    @Transactional
    public Long createCard(CardCreateRequest request) {
        log.info("Creating new card for account: {}", request.getAccountId());
        AccountExistsResponse account = accountsProvider.getAccountExists(request.getAccountId());

        if(Objects.nonNull(account.getExists()) && account.getExists() && Objects.nonNull(account.getCustomerId())) {
            Card card = mapper.mapToCard(request, account.getCustomerId());
            return repository.save(card).getCardId();
        } else {
            //TODO: system of passing errors
            return -1L;
        }
    }

    @Override
    public UserCardsResponse getCustomerCards(Long userId) {
        log.info("Getting cards of user: {}", userId);
        return new UserCardsResponse(
                repository.findAllByCustomerId(userId).stream().map(mapper::mapToSnapshot).collect(Collectors.toList())
        );
    }
}
