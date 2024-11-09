package com.food_delivery_app.service;

import com.food_delivery_app.dto.DeliveryRequest;
import com.food_delivery_app.dto.DeliveryResponse;
import com.food_delivery_app.model.DeliveryStatus;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    // Create a new delivery
    DeliveryResponse createDelivery(DeliveryRequest deliveryRequest);

    // Get all deliveries
    List<DeliveryResponse> getAllDeliveries();

    // Get a delivery by ID
    Optional<DeliveryResponse> getDeliveryById(Long id);

    // Update delivery status
    DeliveryResponse updateDeliveryStatus(Long deliveryId, DeliveryStatus deliveryStatus);

}
