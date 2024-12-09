package com.mms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mms.entity.Booking;
import java.util.List;

@Service
public class BookingRestService {

    @Autowired
    private RestTemplate restTemplate;

    // Fetch booking history from the BookingController API and print it to the console
    public void printBookingHistory(Long userId) {
        // URL of the BookingController's endpoint
        String url = "http://localhost:8080/bookings/user/" + userId;

        // Fetch booking history from the URL using RestTemplate
        List<Booking> bookings = restTemplate.getForObject(url, List.class);

        // Print the bookings to the console
        if (bookings != null && !bookings.isEmpty()) {
            bookings.forEach(booking -> System.out.println(booking));
        } else {
            System.out.println("No bookings found for userId: " + userId);
        }
    }
}
