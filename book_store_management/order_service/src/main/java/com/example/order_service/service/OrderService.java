package com.example.order_service.service;

import com.example.order_service.domain.Order;
import com.example.order_service.dto.Book;
import com.example.order_service.exceptions.OrderNotFoundException;
import com.example.order_service.feign_clients.BookServiceClient;
import com.example.order_service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookServiceClient bookClient;

    public Order saveOrder(Order order){
        log.debug("Placing Order {}", order);
        Book book = bookClient.getBookById(order.getBookId());
        if (book == null || book.getStock() < order.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }
        // Reduce stock and save order
        book.setStock(book.getStock() - order.getQuantity());
        // Assuming a method to update book stock
        bookClient.updateBook(book.getId(), book);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        log.debug("Getting all Orders");
        return List.copyOf(orderRepository.findAll());
    }

    public Order getOrder(long id){
        log.debug("Getting Order, id: {}", id);
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found, id: " + id));
    }

    public Order updateOrder(long id, Order order){
        log.debug("Updating Order: {}", order);
        Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found, id: " + id));
        existingOrder.setCustomerId(order.getCustomerId());
        existingOrder.setBookId(order.getBookId());
        existingOrder.setQuantity(order.getQuantity());
        orderRepository.save(existingOrder);
        return order;
    }

    public void deleteOrder(long id) {
        log.debug("Deleting Order, id: {}", id);
        var order = orderRepository
                .findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found, cannot delete, id: " + id));
        orderRepository.delete(order);
    }


}
