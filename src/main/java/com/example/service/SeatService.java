package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Seat;
import com.example.model.SeatType;
import com.example.repository.SeatRepository;

public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public Seat create(int screenId, SeatType seatType) {
        Seat movie = new Seat(screenId, seatType);
        seatRepository.save(movie);
        return movie;
    }

    public Seat get(int id) {
        return seatRepository.get(id);
    }
    
    public int getSeatsCount(int screenId) {
        return seatRepository.getCount(screenId);
    }
}
