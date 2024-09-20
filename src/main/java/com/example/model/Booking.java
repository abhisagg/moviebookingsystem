package com.example.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;

@Data
public class Booking {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private int id;
    private int showId;
    private int seatId;
    private LocalDateTime created;
    private LocalDateTime updatedAt;
    private BookingStatus bookingStatus; 
    
    public Booking(int showId, int seatId) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.showId = showId;
        this.seatId = seatId;
        this.bookingStatus = BookingStatus.Created;
    }
}
