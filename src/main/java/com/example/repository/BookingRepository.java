package com.example.repository;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.model.Booking;
import java.util.*;

@Component
public class BookingRepository {
    Map<Integer, Booking> bookings = new HashMap<>();

    public void save(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    public Booking get(int id) {
        return bookings.get(id);
    }

    public Booking getBySeatId(int seatId) {
        return bookings.values().stream().filter(b -> b.getSeatId() == seatId).findFirst().orElse(null);
    }
}
