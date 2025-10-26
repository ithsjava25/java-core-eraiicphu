package com.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Category {

    private String name;

    private static final Map<String, Category> cache = new ConcurrentHashMap<>();

    private Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category of(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Category name can't be null");
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("Category name can't be blank");
        }
        String normalizedName = normalize(name);

        return cache.computeIfAbsent(normalizedName, newCat -> new Category(normalizedName));
    }

    private static String normalize(String name) {
        if (name == null) return "";
        name = name.trim();
        if (name.isEmpty()) return name;

        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
