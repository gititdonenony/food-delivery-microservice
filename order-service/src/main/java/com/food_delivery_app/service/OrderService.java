package com.food_delivery_app.service;

import com.food_delivery_app.dto.OrderRequest;
import com.food_delivery_app.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    // Create a new order
    OrderResponse createOrder(OrderRequest orderRequest);

    // Retrieve an order by ID
    OrderResponse getOrderById(String orderId);

    // Retrieve all orders
    List<OrderResponse> getAllOrders();

    // Update an existing order (e.g., change status)
    OrderResponse updateOrder(String orderId, OrderRequest orderRequest);

    // Delete an order by ID
    void deleteOrder(String orderId);

}
