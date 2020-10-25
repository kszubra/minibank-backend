package com.kszu.minibank.users.server.service.interfaces;

import com.kszu.minibank.users.server.api.request.UserCreateRequest;
import com.kszu.minibank.users.server.api.response.UserResponse;
import com.kszu.minibank.users.server.api.snapshot.UserSnapshot;

public interface UserApiService {

    Long createUser(UserCreateRequest request);

    UserResponse getUserResponse(Long userId);

    UserSnapshot getUserSnapshot(Long userId);
}
