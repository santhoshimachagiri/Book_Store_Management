package com.example.customer_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerDto(
        long id,


        @NotEmpty(message = "Name is required")
        @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only letters and spaces")
        @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
        String name,

        @NotEmpty(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        @NotEmpty(message = "Phone number is required")
        @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Phone number should be valid")
        String phone
) {
}
