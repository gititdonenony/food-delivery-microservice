package com.food_delivery_app.dto;

import com.food_delivery_app.model.DeliveryStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryRequest {
    private String orderId;  // Link to the Order Service
    private String customerId;  // Link to the Customer Service (optional)
    private Long deliveryPersonId;  // Link to the Delivery Person (optional)

    private DeliveryStatus deliveryStatus;  // Status of the delivery (Pending, In Transit, Delivered)
    private LocalDateTime assignedDate;  // Timestamp when the delivery is assigned
    private LocalDateTime deliveredDate;  // Timestamp when the delivery is completed

}
