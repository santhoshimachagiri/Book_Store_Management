package com.example.customer_service.domain;


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
@Table(name = "customer_service")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;
    private String name;
    private String email;
    private String phone;
}
