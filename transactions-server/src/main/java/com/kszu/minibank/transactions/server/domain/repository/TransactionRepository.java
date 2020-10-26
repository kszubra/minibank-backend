package com.kszu.minibank.transactions.server.domain.repository;

import com.kszu.minibank.transactions.server.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
