package com.example.book_service.domain;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_service")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;

    private String title;
    private String author;
    private double price;
    private int stock;
}
