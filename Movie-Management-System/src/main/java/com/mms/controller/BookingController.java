package com.mms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mms.entity.Booking;
import com.mms.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    // Book a movie
    @PostMapping
    public Booking bookMovie(@RequestParam Long userId, @RequestParam int movieId) {
        return bookingService.bookMovie(userId, movieId);
    }

    // Fetch booking history
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingHistory(@PathVariable Long userId) {
        return bookingService.getBookingHistory(userId);
    }
}
