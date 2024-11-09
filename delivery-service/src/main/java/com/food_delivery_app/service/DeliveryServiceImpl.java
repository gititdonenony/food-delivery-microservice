package com.food_delivery_app.service;

import com.food_delivery_app.dto.DeliveryRequest;
import com.food_delivery_app.dto.DeliveryResponse;
import com.food_delivery_app.model.Delivery;
import com.food_delivery_app.model.DeliveryStatus;
import com.food_delivery_app.repository.DeliveryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DeliveryResponse createDelivery(DeliveryRequest deliveryRequest) {
        Delivery delivery = modelMapper.map(deliveryRequest, Delivery.class);
        delivery.setDeliveryStatus(DeliveryStatus.PENDING);  // Initially, set to PENDING
        delivery.setAssignedDate(LocalDateTime.now());

        Delivery savedDelivery = deliveryRepository.save(delivery);
        return modelMapper.map(savedDelivery, DeliveryResponse.class);
    }

    @Override
    public List<DeliveryResponse> getAllDeliveries() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        return deliveries.stream()
                .map(delivery -> modelMapper.map(delivery, DeliveryResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DeliveryResponse> getDeliveryById(Long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        return delivery.map(d -> modelMapper.map(d, DeliveryResponse.class));

    }

    @Override
    public DeliveryResponse updateDeliveryStatus(Long deliveryId, DeliveryStatus deliveryStatus) {
        Optional<Delivery> deliveryOpt = deliveryRepository.findById(deliveryId);

        if (deliveryOpt.isPresent()) {
            Delivery delivery = deliveryOpt.get();
            delivery.setDeliveryStatus(deliveryStatus);

            if (deliveryStatus == DeliveryStatus.DELIVERED) {
                delivery.setDeliveredDate(LocalDateTime.now());
            }

            Delivery updatedDelivery = deliveryRepository.save(delivery);
            return modelMapper.map(updatedDelivery, DeliveryResponse.class);
        } else {
            throw new RuntimeException("Delivery not found with ID: " + deliveryId);
        }
    }
}

