package com.food_delivery_app.dto;

import lombok.Data;

@Data
public class RestaurantRequest {
    private String name;
    private String address;
    private String cuisineType;
    private String contactNumber;
    private Boolean isOpen;
}
