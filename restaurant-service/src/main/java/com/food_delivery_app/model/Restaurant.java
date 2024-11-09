package com.food_delivery_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String cuisineType;
    private String contactNumber;
    private Boolean isOpen;

}

