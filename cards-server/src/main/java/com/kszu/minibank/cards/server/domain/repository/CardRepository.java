package com.kszu.minibank.cards.server.domain.repository;

import com.kszu.minibank.cards.server.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByCustomerId(Long customerId);
}
