package com.food_delivery_app.controller;

import com.food_delivery_app.dto.NotificationRequest;
import com.food_delivery_app.dto.NotificationResponse;
import com.food_delivery_app.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    // Endpoint to create a notification
    @PostMapping
    public ResponseEntity<NotificationResponse> createNotification(@RequestBody NotificationRequest notificationRequest) {
        NotificationResponse response = notificationService.createNotification(notificationRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Endpoint to send a notification by its ID
    @PostMapping("/{notificationId}/send")
    public ResponseEntity<NotificationResponse> sendNotification(@PathVariable Long notificationId) {
        NotificationResponse response = notificationService.sendNotification(notificationId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint to get notification details by ID
    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationResponse> getNotificationById(@PathVariable Long notificationId) {
        NotificationResponse response = notificationService.getNotificationById(notificationId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
