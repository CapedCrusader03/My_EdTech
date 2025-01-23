package com.kshitij.edtech.controller;

import com.kshitij.edtech.service.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationProducer notificationProducer;

    @PostMapping("/send")
    public String sendNotification(@RequestParam String routingKey, @RequestBody String message) {
        notificationProducer.sendNotification(routingKey, message);
        return "Notification sent with routing key [" + routingKey + "]: " + message;
    }
}
