package com.example.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.model.Seat;

@Component
public class SeatRepository {
    Map<Integer, Seat> seats = new HashMap<>();

    public void save(Seat seat) {
        seats.put(seat.getId(), seat);
    }

    public Seat get(int id) {
        return seats.get(id);
    }

    public int getCount(int screenId) {
        return seats.values().stream().filter(s -> s.getScreenId() == screenId).mapToInt(s -> 1).sum();
    }
}
