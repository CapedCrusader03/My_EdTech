package com.kshitij.edtech.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Define the exchange
    @Bean
    public TopicExchange notificationExchange() {
        return new TopicExchange("notification-exchange");
    }

    // Define queues
    @Bean
    public Queue teacherNotificationQueue() {
        return new Queue("teacher-notifications", false);
    }

    @Bean
    public Queue adminNotificationQueue() {
        return new Queue("admin-notifications", false);
    }

    // Bind queues to the exchange with routing keys
    @Bean
    public Binding teacherBinding(Queue teacherNotificationQueue, TopicExchange notificationExchange) {
        return BindingBuilder.bind(teacherNotificationQueue).to(notificationExchange).with("teacher.#");
    }

    @Bean
    public Binding adminBinding(Queue adminNotificationQueue, TopicExchange notificationExchange) {
        return BindingBuilder.bind(adminNotificationQueue).to(notificationExchange).with("admin.#");
    }
}
