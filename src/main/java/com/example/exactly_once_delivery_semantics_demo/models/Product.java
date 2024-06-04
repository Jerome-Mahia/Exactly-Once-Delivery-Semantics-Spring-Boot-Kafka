package com.example.exactly_once_delivery_semantics_demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private Double price;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"price\":\"" + price + '\"' +
                "}";
    }
}
