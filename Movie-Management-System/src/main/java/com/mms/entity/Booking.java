package com.mms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private Long userId;    // Foreign key linking to User
    private Long movieId;   // Foreign key linking to Movie
    private LocalDate bookingDate;
    private String status;  // e.g., "Confirmed", "Pending"
    private String streamingLink; // URL to stream the movie

    public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(Long bookingId, Long userId, Long movieId, LocalDate bookingDate, String status,
			String streamingLink) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.movieId = movieId;
		this.bookingDate = bookingDate;
		this.status = status;
		this.streamingLink = streamingLink;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStreamingLink() {
		return streamingLink;
	}

	public void setStreamingLink(String streamingLink) {
		this.streamingLink = streamingLink;
	}

	  @Override
	    public String toString() {
	        return "Booking{" +
	                "bookingId=" + bookingId +
	                ", userId=" + userId +
	                ", movieId=" + movieId +
	                ", bookingDate=" + bookingDate +
	                ", status='" + status + '\'' +
	                ", streamingLink='" + streamingLink + '\'' +
	                '}';
	    }
    
	
}

