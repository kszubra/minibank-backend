package com.kszu.minibank.users.server.web;

import com.kszu.minibank.users.server.api.request.UserCreateRequest;
import com.kszu.minibank.users.server.api.response.UserResponse;
import com.kszu.minibank.users.server.service.interfaces.UserApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserApiService apiService;

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return apiService.getUserResponse(userId);
    }

    @PostMapping
    public Long createUSer(@RequestBody UserCreateRequest request) {
        return apiService.createUser(request);
    }
}
