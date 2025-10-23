package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public abstract class Product {

    private final UUID id;
    private final String name;
    private BigDecimal price;
    private final Category category;

    public Product(UUID id, String name, Category category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public UUID uuid() {
        return id;
    }

    public String name() {
        return name;
    }

    public BigDecimal price() {
        return price;
    }

    public Category category() {
        return category;
    }

    public void price(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("price cannot be null");
        }
        this.price = price;
    }

    public abstract String productDetails();

}
