package com.example.model;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;

@Data
public class Movie {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private int id;
    private String name;

    public Movie(String name) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
    }
}
