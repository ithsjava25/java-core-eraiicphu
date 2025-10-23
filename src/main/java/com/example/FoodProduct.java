package com.example;

import com.example.Category;
import com.example.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class FoodProduct extends Product {
    private LocalDate expirationDate;
    private BigDecimal weight;

    public FoodProduct(UUID id, String name, Category category, BigDecimal price, LocalDate expirationDate, BigDecimal weight) {
        super(id, name, category, price);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    public FoodProduct of(UUID id, String name, Category category, BigDecimal price, LocalDate expirationDate, BigDecimal weight){
        if(!validateWeight(weight)){
            throw new IllegalArgumentException("Weight must be greater than zero");
        }

        if(!validatePrice(price)){
            throw new IllegalArgumentException("Price must be greater than zero");
        }

        return new FoodProduct(id, name, category, price, expirationDate, weight);
    }

    private boolean validatePrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        return true;
    }

    private boolean validateWeight(BigDecimal weight) {
        if (weight.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        return true;
    }
    public LocalDate ExpirationDate() {
        return expirationDate;
    }
    public BigDecimal shippingCost() {
        return weight.multiply(BigDecimal.valueOf(50));
    }
    public String productDetails() {
        return String.format("Food: %s, Expires: %s", name(), expirationDate.toString());
    }

}
