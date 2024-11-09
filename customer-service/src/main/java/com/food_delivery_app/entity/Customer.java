package com.food_delivery_app.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@Data
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
