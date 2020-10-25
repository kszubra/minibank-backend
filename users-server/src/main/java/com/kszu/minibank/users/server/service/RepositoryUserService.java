package com.kszu.minibank.users.server.service;

import com.kszu.minibank.users.server.api.request.UserCreateRequest;
import com.kszu.minibank.users.server.api.response.UserResponse;
import com.kszu.minibank.users.server.api.snapshot.UserSnapshot;
import com.kszu.minibank.users.server.domain.model.User;
import com.kszu.minibank.users.server.domain.repository.UserRepository;
import com.kszu.minibank.users.server.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class RepositoryUserService implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;

    @Override
    @Transactional
    public Long createUser(UserCreateRequest request) {
        log.debug("Creating new user with email: {}", MaskUtils.maskEmail(request.getEmail()));
        Long id = repository.save(mapper.mapToEntity(request)).getUserId();
        log.info("Added user with id: {}", id);
        return id;
    }

    @Override
    public UserResponse getUserResponse(Long userId) {
        log.debug("Getting user response for id: {}", userId);
        return mapper.mapToResponse(getById(userId));
    }

    @Override
    public UserSnapshot getUserSnapshot(Long userId) {
        log.debug("Getting user snapshot with id: {}", userId);
        return mapper.mapToSnapshot(getById(userId));
    }

    private User getById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
