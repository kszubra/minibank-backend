package com.kszu.minibank.users.server.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserResponse {

    private Long id;

    private String firstName;

    private String lastName;
}
