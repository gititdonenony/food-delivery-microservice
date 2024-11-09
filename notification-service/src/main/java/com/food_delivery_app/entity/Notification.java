package com.food_delivery_app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipientEmail;  // User's email to receive the notification
    private String subject;         // Subject of the notification
    private String message;         // Message body/content of the notification
    private String status;          // Status (e.g., "Sent", "Pending", "Failed")

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;  // Date and time the notification was created

    @Column(name = "sent_date")
    private LocalDateTime sentDate;     // Date and time the notification was sent

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
