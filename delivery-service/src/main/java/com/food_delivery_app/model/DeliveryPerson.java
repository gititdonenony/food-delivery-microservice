package com.food_delivery_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DeliveryPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the delivery person

    @Column(nullable = false)
    private String name;  // Name of the delivery person

    @Column(nullable = false)
    private String contact;  // Contact information

    @Column(nullable = false)
    private boolean available;  // Availability status (True/False)

}
