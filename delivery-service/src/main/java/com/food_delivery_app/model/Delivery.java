package com.food_delivery_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the delivery

    @Column(nullable = false)
    private String orderId;  // Link to the Order Service

    @Column(nullable = false)
    private String customerId;  // Link to the Customer Service (optional)

    @Column(nullable = false)
    private Long deliveryPersonId;  // Link to the Delivery Person (optional)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus deliveryStatus;  // Status of the delivery (Pending, In Transit, Delivered)

    private LocalDateTime assignedDate;  // Timestamp when the delivery is assigned
    private LocalDateTime deliveredDate;  // Timestamp when the delivery is completed


}
