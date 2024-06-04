package com.example.exactly_once_delivery_semantics_demo.services;

import com.example.exactly_once_delivery_semantics_demo.models.ProductMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductProducer {
    final String productTopic = "product";

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    public void send(ProductMessage message) {
        CompletableFuture<SendResult<String, Serializable>> future = kafkaTemplate.send(productTopic, message);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Unable to send message = {} due to: {}", message.toString(), ex.getMessage());
            } else {
                log.info("Message sent successfully with offset = {}", result.getRecordMetadata().offset());
            }
        });
    }
}
