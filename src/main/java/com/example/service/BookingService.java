package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Booking;
import com.example.model.Seat;
import com.example.repository.BookingRepository;

public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowService showService;

    @Autowired
    private SeatService seatService;


    public Booking bookSeat(int showId, int seatId) {
        Seat seat = seatService.get(seatId);
        if (seat == null) {
            System.out.println("Seat with id doesn't exists");
            return null;
        }
        synchronized(seat) {
            if (bookingRepository.getBySeatId(seatId) != null) {
                System.out.println("Seat already booked");
                return null;
            }
            Booking booking = new Booking(showId, seatId);
            bookingRepository.save(booking);
            showService.decrementSeatCount(showId);
            return booking;
        }
    }

    public Booking get(int id) {
        return bookingRepository.get(id);
    }
}
