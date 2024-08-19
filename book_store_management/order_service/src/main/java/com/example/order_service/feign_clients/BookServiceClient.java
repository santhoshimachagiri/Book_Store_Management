package com.example.order_service.feign_clients;

import com.example.order_service.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "book-service", url = "http://localhost:8100/books")
public interface BookServiceClient {
    @GetMapping("/{id}")
    Book getBookById(@PathVariable long id);

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book);
}
