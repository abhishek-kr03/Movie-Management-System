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


//@RestController
//@RequestMapping("/bookings")
//public class BookingController {
//
//    private final RestTemplate restTemplate;
//
//    // Constructor injection
//    public BookingController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    // Example endpoint using RestTemplate
//    @GetMapping("/movie-details/{movieId}")
//    public String getMovieDetails(@PathVariable int movieId) {
//        // URL to call Movie Service API
//        String movieServiceUrl = "http://localhost:8081/movies/" + movieId;
//
//        // Fetch movie details from the Movie Service using RestTemplate
//        String movieDetails = restTemplate.getForObject(movieServiceUrl, String.class);
//
//        return movieDetails; // Return the response as is
//    }
//}











