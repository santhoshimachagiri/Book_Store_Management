package com.example.customer_service.converter;

import com.example.customer_service.domain.Customer;
import com.example.customer_service.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDtoConverter {
    public static List<CustomerDto> toDTOs(List<Customer> customers){
        return customers.stream().map(CustomerDtoConverter::fromEntity).toList();
    }

    public static CustomerDto fromEntity(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(),
                customer.getEmail(), customer.getPhone());
    }

    public Customer toEntity(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        customer.setPhone(dto.phone());
        return customer;
    }
}
