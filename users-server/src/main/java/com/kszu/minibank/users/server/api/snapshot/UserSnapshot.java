package com.kszu.minibank.users.server.api.snapshot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserSnapshot {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDateTime createdAt;

    private boolean isActive;
}
