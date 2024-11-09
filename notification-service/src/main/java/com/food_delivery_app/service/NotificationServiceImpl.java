package com.food_delivery_app.service;

import com.food_delivery_app.dto.NotificationRequest;
import com.food_delivery_app.dto.NotificationResponse;
import com.food_delivery_app.entity.Notification;
import com.food_delivery_app.repository.NotificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NotificationResponse createNotification(NotificationRequest notificationRequest) {
        Notification notification = modelMapper.map(notificationRequest, Notification.class);
        notification.setStatus("Pending");
        notification.setCreatedDate(LocalDateTime.now());
        notificationRepository.save(notification);
        return modelMapper.map(notification, NotificationResponse.class);

    }

    @Override
    public NotificationResponse sendNotification(Long notificationId) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        if (optionalNotification.isPresent()) {
            Notification notification = optionalNotification.get();

            // Prepare the email
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(notification.getRecipientEmail());
            mailMessage.setSubject(notification.getSubject());
            mailMessage.setText(notification.getMessage());

            try {
                mailSender.send(mailMessage);
                notification.setStatus("Sent");
                notification.setSentDate(LocalDateTime.now());
            } catch (Exception e) {
                notification.setStatus("Failed");
                e.printStackTrace();
            }

            notificationRepository.save(notification);
            return modelMapper.map(notification, NotificationResponse.class);
        } else {
            throw new RuntimeException("Notification not found with ID: " + notificationId);
        }
    }

    @Override
    public NotificationResponse getNotificationById(Long notificationId) {
        Notification notification = notificationRepository.findById(Long.valueOf(notificationId))
                .orElseThrow(() -> new RuntimeException("Notification not found with ID: " + notificationId));
        return modelMapper.map(notification, NotificationResponse.class);
    }
}


