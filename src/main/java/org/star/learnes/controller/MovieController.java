package org.star.learnes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> listMovie() {
        return ResponseEntity.ok(movieService.listMovie());
    }

}
