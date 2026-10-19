package org.example.validation.model;

import lombok.Builder;

@Builder
public record User(
        String id,
        String username,
        Integer age,
        String email,
        String password
) {
}