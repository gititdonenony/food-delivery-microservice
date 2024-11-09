package com.food_delivery_app.controller;

import com.food_delivery_app.dto.DeliveryRequest;
import com.food_delivery_app.dto.DeliveryResponse;
import com.food_delivery_app.model.DeliveryStatus;
import com.food_delivery_app.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    // Create a new delivery
    @PostMapping
    public ResponseEntity<DeliveryResponse> createDelivery(@RequestBody DeliveryRequest deliveryRequest) {
        DeliveryResponse deliveryResponse = deliveryService.createDelivery(deliveryRequest);
        return ResponseEntity.status(201).body(deliveryResponse);  // Return HTTP 201 (Created)
    }

    // Get all deliveries
    @GetMapping
    public ResponseEntity<List<DeliveryResponse>> getAllDeliveries() {
        List<DeliveryResponse> deliveryResponses = deliveryService.getAllDeliveries();
        return ResponseEntity.ok(deliveryResponses);
    }

    // Get a delivery by ID
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponse> getDeliveryById(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());  // HTTP 404 if not found
    }

    // Update delivery status (e.g., PENDING -> IN_TRANSIT -> DELIVERED)
    @PutMapping("/{id}/status")
    public ResponseEntity<DeliveryResponse> updateDeliveryStatus(
            @PathVariable Long id, @RequestParam DeliveryStatus deliveryStatus) {
        DeliveryResponse updatedDeliveryResponse = deliveryService.updateDeliveryStatus(id, deliveryStatus);
        return ResponseEntity.ok(updatedDeliveryResponse);
    }
}
