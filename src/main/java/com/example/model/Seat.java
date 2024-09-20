package com.example.model;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;

@Data
public class Seat {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    
    private int id;
    private int screenId;
    private int row;
    private int col;
    private SeatType seatType;

    public Seat(int screenId, SeatType seatType) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.screenId = screenId;
        this.seatType = seatType;
    }
}
