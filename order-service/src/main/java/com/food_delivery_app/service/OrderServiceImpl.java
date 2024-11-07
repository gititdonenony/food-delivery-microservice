package com.food_delivery_app.service;

import com.food_delivery_app.dto.OrderRequest;
import com.food_delivery_app.dto.OrderResponse;
import com.food_delivery_app.entity.Order;
import com.food_delivery_app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        // Convert request DTO to entity
        Order order = modelMapper.map(orderRequest, Order.class);
        // Save order to the database
        Order savedOrder = orderRepository.save(order);
        // Convert saved entity to response DTO and return
        return modelMapper.map(savedOrder, OrderResponse.class);
    }

    @Override
    public OrderResponse getOrderById(String orderId) {
        // Find order by ID
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        // Convert to response DTO
        return modelMapper.map(order, OrderResponse.class);

    }

    @Override
    public List<OrderResponse> getAllOrders() {
        // Retrieve all orders, map each to response DTO
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse updateOrder(String orderId, OrderRequest orderRequest) {
        // Find the order by ID
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        // Update fields from the request DTO
        existingOrder.setCustomerId(orderRequest.getCustomerId());
        existingOrder.setRestaurantId(orderRequest.getRestaurantId());
        existingOrder.setTotalAmount(orderRequest.getTotalAmount());
        existingOrder.setItems(List.of(orderRequest.getOrderDetails()));  // Update items list

        // Save updated order
        Order updatedOrder = orderRepository.save(existingOrder);

        // Convert to response DTO
        return modelMapper.map(updatedOrder, OrderResponse.class);
    }

    @Override
    public void deleteOrder(String orderId) {
        // Find order by ID and delete
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        orderRepository.delete(order);

    }
}
