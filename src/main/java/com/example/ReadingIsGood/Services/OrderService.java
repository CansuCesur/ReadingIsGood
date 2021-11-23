package com.example.ReadingIsGood.Services;

import com.example.ReadingIsGood.Models.Order;
import com.example.ReadingIsGood.Repositories.OrderRepository;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByCustomerId(String id) {
        return orderRepository.findOrdersByCustomerId(id);
    }

    public Order getOrderById(String id) {
        return orderRepository.findOrderById(id);
    }

    public List<Order> getOrdersByStartDateBetween(Date startDate, Date endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

}
