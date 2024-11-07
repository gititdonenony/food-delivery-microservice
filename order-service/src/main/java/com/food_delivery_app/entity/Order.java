package com.food_delivery_app.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
@Data
public class Order {
    @Id
    private String customerId;  // Reference to the Customer
    private Long restaurantId;  // Reference to the Restaurant
    private List<String> items;
    private double totalAmount;
    private String status;  // Status of the order (e.g., "Pending", "Completed", "Cancelled")
    private LocalDateTime orderDate;
}
