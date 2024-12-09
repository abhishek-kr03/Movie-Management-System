package com.mms.controller;

import com.mms.entity.Movie;
import com.mms.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/movies")
//public class MovieController {
//
//    @Autowired
//    private MovieService movieService;
//
//    
//    @PostMapping
//    public Movie addMovie(@RequestBody Movie movie) {
//        return movieService.saveMovie(movie);
//    }
//
//    
//    @GetMapping
//    public List<Movie> getAllMovies() {
//        return movieService.getAllMovies();
//    }
//    
//    @PutMapping("/{id}")
//    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
//        return movieService.updateMovie(id, movie);
//    }
//}
















@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) {
        return movieService.getMovieById(movieId);
    }
}
