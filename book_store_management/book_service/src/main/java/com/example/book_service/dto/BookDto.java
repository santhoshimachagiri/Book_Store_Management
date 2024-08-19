package com.example.book_service.dto;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

public record BookDto(

        long id,

        @NotEmpty(message = "Title is required")
        @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only letters and spaces")
        @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
        String title,

        @NotEmpty(message = "Name is required")
        @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only letters and spaces")
        @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
        String author,

        @NotNull(message = "Prize should not be null")
        @DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than 0")
        @Digits(integer = 10, fraction = 2, message = "Price must have up to 2 decimal places")
        double prize,

        @NotNull(message = "Stock must be provided")
        @PositiveOrZero(message = "Stock must be 0 or more")
        int stock

) {
}
