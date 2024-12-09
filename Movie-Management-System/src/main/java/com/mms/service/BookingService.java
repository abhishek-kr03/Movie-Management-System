package com.mms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.entity.Booking;
import com.mms.entity.Movie;
import com.mms.entity.User;
import com.mms.repository.BookingRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;  // To validate user

    @Autowired
    private MovieService movieService; // To validate movie availability
    
    @Autowired
    private BookingRestService bookingRestService;  // Autowire the BookingRestService

    // Book a movie
    @SuppressWarnings("unused")
	public Booking bookMovie(Long userId, int movieId) {
        // Validate user
        User user = userService.getUserById(userId);

        // Validate movie
        Movie movie = movieService.getMovieById(movieId);
        if (movie == null) {
            throw new RuntimeException("Movie not available");
        }

        // Create and save booking
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setMovieId((long) movieId);
        booking.setBookingDate(LocalDate.now());
        booking.setStatus("Confirmed");
        booking.setStreamingLink("https://streamingservice.com/watch/" + movieId); // Generate a dynamic streaming link

        return bookingRepository.save(booking);
    }

    // Fetch booking history by userId
    public List<Booking> getBookingHistory(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
    
    // Call this method to print booking history for a user
    public void fetchAndPrintBookingHistory(Long userId) {
        bookingRestService.printBookingHistory(userId);  // Call the RestService to print bookings
    }
}
