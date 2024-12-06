package com.mms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.entity.Movie;
import com.mms.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    
    public Movie updateMovie(Integer id, Movie movie) {
        if (!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("Movie not found");
        }

        movie.setMovieId(id); // Ensure the movie has the correct ID
        return movieRepository.save(movie);
    }
    
    public Movie getMovieById(int movieId) {
        return movieRepository.findById(movieId).orElse(null); // Returns the movie if found, otherwise null
    }
}
