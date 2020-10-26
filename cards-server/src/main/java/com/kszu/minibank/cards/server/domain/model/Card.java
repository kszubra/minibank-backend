package com.kszu.minibank.cards.server.domain.model;

import com.kszu.minibank.cards.server.api.enumeration.CardProvider;
import com.kszu.minibank.cards.server.api.enumeration.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @NotNull
    private Long customerId;

    @NotNull
    @Column(unique = true)
    private String cardNumber;

    @NotNull
    private Long account;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CardProvider cardProvider;

    @NotNull
    private LocalDate expirationDate;

    @NotNull
    private String cvvNumber;

    @NotNull
    @Setter
    private Boolean isActive;
}
