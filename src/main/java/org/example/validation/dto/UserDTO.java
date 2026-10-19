package org.example.validation.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


public record UserDTO(
        @NotEmpty
        @Size(min = 3, max = 50)
        String username,
        @Min(16)
        Integer age,
        @Email
        String email,
        @Pattern(regexp = "^(?=.*!)(?=.*@)(?=.*\\d).{8,}$")
        String password
) {
}
