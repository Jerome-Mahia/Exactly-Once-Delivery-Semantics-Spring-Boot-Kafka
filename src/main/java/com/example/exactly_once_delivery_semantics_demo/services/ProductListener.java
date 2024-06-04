package com.example.exactly_once_delivery_semantics_demo.services;

import com.example.exactly_once_delivery_semantics_demo.models.ProductMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductListener {
    @KafkaListener(topics = "product", containerFactory = "kafkaListenerContainerFactory")
    public void newProductListener(ProductMessage product) {
        log.info("Get request from product topic " + product.toString());
    }
}
