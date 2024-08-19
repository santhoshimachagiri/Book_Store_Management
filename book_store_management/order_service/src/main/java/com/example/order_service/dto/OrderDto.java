package com.example.order_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record OrderDto(

        long id,

        @NotNull(message = "ID is required")
        long bookId,

        long customerId,

        @NotNull(message = "Quantity is required")
        @Positive(message = "Quantity must be greater than 0")
        Integer quantity,

        @NotNull(message = "Status is required")
        @Pattern(regexp = "PENDING|CONFIRMED|CANCELLED", message = "Status must be one of 'PENDING', 'CONFIRMED', or 'CANCELLED'")
        String status

) {
}
