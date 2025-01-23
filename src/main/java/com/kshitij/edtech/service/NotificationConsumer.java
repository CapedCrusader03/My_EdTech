package com.kshitij.edtech.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = "teacher-notifications")
    public void receiveTeacherNotification(String message) {
        System.out.println("Teacher Notification Received: " + message);
        // Add logic to notify teachers
    }

    @RabbitListener(queues = "admin-notifications")
    public void receiveAdminNotification(String message) {
        System.out.println("Admin Notification Received: " + message);
        // Add logic to notify admins
    }
}
