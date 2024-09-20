package com.example.model;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;

@Data
public class Screen {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    int id;
    int theatreId;

    public Screen(int theatreId) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.theatreId = theatreId;
    }
}
