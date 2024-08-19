package com.example.order_service.dto;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    private Long id;
    private String title;
    private int stock;
}
