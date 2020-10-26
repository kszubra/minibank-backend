package com.kszu.minibank.cards.server.api.response;

import com.kszu.minibank.cards.server.api.snapshot.CardSnapshot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserCardsResponse {

    private List<CardSnapshot> cards;
}
