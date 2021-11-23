package com.example.ReadingIsGood.Repositories;

import com.example.ReadingIsGood.Models.Order;
import java.util.Date;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findOrdersByCustomerId(String id);

    Order findOrderById(String id);

    List<Order> findByOrderDateBetween(Date startDate, Date endDate);

}
