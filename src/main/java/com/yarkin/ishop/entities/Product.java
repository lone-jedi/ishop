package com.yarkin.ishop.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Builder
@ToString
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

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
