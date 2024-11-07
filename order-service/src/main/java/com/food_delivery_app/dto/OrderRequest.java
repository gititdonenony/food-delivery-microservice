package com.food_delivery_app.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequest {
    private String customerId;
    private Long restaurantId;
    private double totalAmount;
    private String orderDetails;  // Additional order details, like items ordered, etc.

}
