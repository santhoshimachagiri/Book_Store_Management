package com.example.order_service.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_service")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;

    private long bookId;
    private long customerId;
    private int quantity;
    private String status;
}
