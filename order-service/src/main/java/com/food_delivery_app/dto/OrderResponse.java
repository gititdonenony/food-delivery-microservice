package com.food_delivery_app.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponse {
    private String orderId;
    private String customerId;
    private Long restaurantId;
    private double totalAmount;
    private String status;  // Status of the order (e.g., "Pending", "Confirmed", "Delivered")

}
