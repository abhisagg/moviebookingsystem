package com.example.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;

@Data
public class Show {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private int id;
    private int theatreId;
    private int movieId;
    private int screenId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Map<SeatType, Integer> priceMap;
    private int seatsLeft;

    public Show(int theatreId, int movieId, int screenId, LocalDateTime startTime, LocalDateTime endTime, Map<SeatType, Integer> priceMap) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.theatreId = theatreId;
        this.movieId = movieId;
        this.screenId = screenId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priceMap = priceMap;
    }
}
