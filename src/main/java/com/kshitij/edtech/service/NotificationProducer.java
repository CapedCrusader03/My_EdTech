package com.kshitij.edtech.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNotification(String routingKey, String message) {
        rabbitTemplate.convertAndSend("notification-exchange", routingKey, message);
        System.out.println("Message sent to RabbitMQ with routing key [" + routingKey + "]: " + message);
    }
}
