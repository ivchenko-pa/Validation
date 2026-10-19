package org.example.validation.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


public record UserDTO(
        @NotEmpty
        @Size(min = 3, max = 50, message = "Username should not be empty and have at least 3 chars and be up to 50 chars long")
        String username,
        @Min(value = 16, message = "Users younger 16 y.o. are not allowed")
        Integer age,
        @Email(message = "Email should correspond xxx@xxx.xxx address format")
        String email,
        @Pattern(regexp = "^(?=.*!)(?=.*@)(?=.*\\d).{8,}$", message = "Password should be at least: 8 chars long, has one '@' and '!' and one digit")
        String password
) {
}
