package com.food_delivery_app.repository;

import com.food_delivery_app.entity.Order;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    // Custom query to find orders by customerId
    List<Order> findByCustomerId(String customerId);  // Find orders by customer ID

}
