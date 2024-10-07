package com.amazon.itemservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import com.amazon.itemservice.dto.Product;
import org.springframework.stereotype.Service;

@Service
public class InboundItemsServiceKafkaPublisher {
    private KafkaTemplate<String, Product> kafkaTemplate;
    private final String TOPIC_NAME = "any-topic-name"; // Replace with your desired topic name



    public InboundItemsServiceKafkaPublisher(KafkaTemplate<String, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Product publishProduct(Product product) {
        kafkaTemplate.send(TOPIC_NAME, product);
        System.out.println("Message " + product +
                " has been sucessfully sent to the topic: " + TOPIC_NAME);
        return product;
    }
}
