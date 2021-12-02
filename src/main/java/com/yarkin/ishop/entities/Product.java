package com.yarkin.ishop.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private double price;
    private Timestamp creationDate;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
