package com.kszu.minibank.users.server.domain.repository;

import com.kszu.minibank.users.server.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
