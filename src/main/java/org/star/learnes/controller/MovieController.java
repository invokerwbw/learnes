package org.star.learnes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.star.learnes.domain.Movie;
import org.star.learnes.service.MovieService;

import java.util.List;

/**
 * 电影REST
 */
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {

        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }


    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> listMovie() {
        return ResponseEntity.ok(movieService.listMovie());
    }

    @RequestMapping(value = "/movies/{page}/{size}", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> listMovie(@PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(movieService.listMovie(page, size));
    }

}
