package com.food_delivery_app.dto;

import lombok.Data;

@Data
public class NotificationRequest {
    private String recipientEmail;
    private String subject;
    private String message;
}
