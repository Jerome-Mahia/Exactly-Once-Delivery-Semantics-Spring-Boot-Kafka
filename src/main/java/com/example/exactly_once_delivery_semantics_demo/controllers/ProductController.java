package com.example.exactly_once_delivery_semantics_demo.controllers;

import com.example.exactly_once_delivery_semantics_demo.models.Product;
import com.example.exactly_once_delivery_semantics_demo.models.ProductMessage;
import com.example.exactly_once_delivery_semantics_demo.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    final ProductService productService;

    @GetMapping("/products")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        log.info("[DemoController]: add new product = " + product.toString());
        this.productService.sendMessage(new ProductMessage(product, "add"));
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable String id) {
        log.info("[DemoController]: delete product id = " + id);
        Product p = new Product();
        p.setId(id);
        this.productService.sendMessage(new ProductMessage(p, "delete"));
    }
}
