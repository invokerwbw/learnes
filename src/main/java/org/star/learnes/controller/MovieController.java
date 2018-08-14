package org.star.learnes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.star.learnes.domain.Movie;
import org.star.learnes.service.MovieService;

/**
 * 电影REST
 */
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 保存电影
     *
     * @param movie
     * @return
     */
    @PostMapping(value = "/movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    /**
     * 根据ID获取指定电影
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {

        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * 获取电影列表（使用默认分页）
     *
     * @return
     */
    @GetMapping(value = "/movies")
    public ResponseEntity<Page<Movie>> listMovie() {
        return ResponseEntity.ok(movieService.listMovie());
    }

    /**
     * 获取电影列表（带分页参数）
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/movies/{page}/{size}")
    public ResponseEntity<Page<Movie>> listMovie(@PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(movieService.listMovie(page, size));
    }

}
