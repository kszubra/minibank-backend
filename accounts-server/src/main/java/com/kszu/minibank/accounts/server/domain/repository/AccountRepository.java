package com.kszu.minibank.accounts.server.domain.repository;

import com.kszu.minibank.accounts.server.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByAccountNumber(String nrb);

    List<Account> findAllByUserId(Long customerId);

    Optional<Account> findByAccountNumber(String nrb);
}
