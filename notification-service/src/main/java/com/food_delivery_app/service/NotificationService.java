package com.food_delivery_app.service;

import com.food_delivery_app.dto.NotificationRequest;
import com.food_delivery_app.dto.NotificationResponse;

import java.util.List;

public interface NotificationService {
    // Create and save a new notification
    NotificationResponse createNotification(NotificationRequest notificationRequest);

    // Send a notification (email) based on the notification ID
    NotificationResponse sendNotification(Long notificationId);

    // Retrieve notification details by ID
    NotificationResponse getNotificationById(Long notificationId);
}
