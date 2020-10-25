package com.kszu.minibank.users.server.service;

import com.kszu.minibank.users.server.api.request.UserCreateRequest;
import com.kszu.minibank.users.server.api.response.UserResponse;
import com.kszu.minibank.users.server.api.snapshot.UserSnapshot;
import com.kszu.minibank.users.server.service.interfaces.UserApiService;
import com.kszu.minibank.users.server.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultUserApiService implements UserApiService {

    private final UserService userService;

    @Override
    public Long createUser(UserCreateRequest request) {
        return userService.createUser(request);
    }

    @Override
    public UserResponse getUserResponse(Long userId) {
        return userService.getUserResponse(userId);
    }

    @Override
    public UserSnapshot getUserSnapshot(Long userId) {
        return userService.getUserSnapshot(userId);
    }
}
