package com.example.exactly_once_delivery_semantics_demo.services;

import com.example.exactly_once_delivery_semantics_demo.models.ProductMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductService {
    private ProductProducer productProducer;

    @Autowired
    public ProductService(ProductProducer productProducer) {
        this.productProducer = productProducer;
    }

    public void sendMessage(ProductMessage message) {
        log.info("[ProductService] send product to topic");
        productProducer.send(message);
    }

}