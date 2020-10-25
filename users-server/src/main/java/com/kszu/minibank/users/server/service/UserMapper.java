package com.kszu.minibank.users.server.service;

import com.kszu.minibank.users.server.api.request.UserCreateRequest;
import com.kszu.minibank.users.server.api.response.UserResponse;
import com.kszu.minibank.users.server.api.snapshot.UserSnapshot;
import com.kszu.minibank.users.server.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToEntity(UserCreateRequest request) {
        return User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .isActive(true)
                .build();
    }

    public UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .id(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public UserSnapshot mapToSnapshot(User user) {
        return UserSnapshot.builder()
                .id(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .isActive(user.getIsActive())
                .build();
    }
}
