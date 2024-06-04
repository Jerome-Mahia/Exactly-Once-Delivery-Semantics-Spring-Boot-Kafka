package com.example.exactly_once_delivery_semantics_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@Slf4j
public class ExactlyOnceDeliverySemanticsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExactlyOnceDeliverySemanticsDemoApplication.class, args);
        log.warn("Demo app run! " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss")));
    }
}
