package com.example.order_service.dto;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Customer {

    private Long id;
    private String name;
}
