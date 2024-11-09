package com.food_delivery_app.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponse {
    private String id;
    private String recipientEmail;
    private String subject;
    private String message;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime sentDate;
}
