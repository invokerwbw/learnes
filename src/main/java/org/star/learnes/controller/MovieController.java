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
    @PutMapping(value = "/movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    /**
     * 修改电影
     *
     * @param movie
     * @return
     */
    @PostMapping(value = "/movie")
    public ResponseEntity<Movie> modifyMovie(@RequestBody Movie movie) {
        Movie result = movieService.modifyMovie(movie);
        if (movie != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 根据ID获取指定电影
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {

        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * 根据排名获取指定电影
     *
     * @param ranking
     * @return
     */
    @GetMapping(value = "/movie_ranking/{ranking}")
    public ResponseEntity<Movie> getMovieByRanking(@PathVariable Integer ranking) {

        Movie movie = movieService.getMovieByRanking(ranking);
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
     * 获取电影列表（需分页参数）
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/movies/{page}/{size}")
    public ResponseEntity<Page<Movie>> listMovie(@PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(movieService.listMovie(page, size));
    }

    /**
     * 按年份获取电影列表（需分页参数）
     *
     * @param year
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/movies_year/{year}/{page}/{size}")
    public ResponseEntity<Page<Movie>> listMovieByYear(@PathVariable String year, @PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(movieService.listMovieByYear(year, page, size));
    }

    /**
     * 按年份获取电影列表（使用默认分页）
     *
     * @param year
     * @return
     */
    @GetMapping(value = "/movies_year/{year}")
    public ResponseEntity<Page<Movie>> listMovieByYear(@PathVariable String year) {
        return ResponseEntity.ok(movieService.listMovieByYear(year));
    }

    /**
     * 按名称获取电影列表（需分页参数）
     *
     * @param title
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/movies_title/{title}/{page}/{size}")
    public ResponseEntity<Page<Movie>> listMovieByTitle(@PathVariable String title, @PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(movieService.listMovieByTitle(title, page, size));
    }

    /**
     * 按名称获取电影列表（使用默认分页）
     *
     * @param title
     * @return
     */
    @GetMapping(value = "/movies_title/{title}")
    public ResponseEntity<Page<Movie>> listMovieByTitle(@PathVariable String title) {
        return ResponseEntity.ok(movieService.listMovieByTitle(title));
    }

    /**
     * 按导演获取电影列表（需分页参数）
     *
     * @param director
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/movies_director/{director}/{page}/{size}")
    public ResponseEntity<Page<Movie>> listMovieByDirector(@PathVariable String director, @PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(movieService.listMovieByDirector(director, page, size));
    }

    /**
     * 按导演获取电影列表（使用默认分页）
     *
     * @param director
     * @return
     */
    @GetMapping(value = "/movies_director/{director}")
    public ResponseEntity<Page<Movie>> listMovieByDirector(@PathVariable String director) {
        return ResponseEntity.ok(movieService.listMovieByDirector(director));
    }

    /**
     * 按标签获取电影列表（需分页参数）
     *
     * @param tag
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/movies_tag/{tag}/{page}/{size}")
    public ResponseEntity<Page<Movie>> listMovieByTag(@PathVariable String tag, @PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(movieService.listMovieByTag(tag, page, size));
    }

    /**
     * 按标签获取电影列表（使用默认分页）
     *
     * @param tag
     * @return
     */
    @GetMapping(value = "/movies_tag/{tag}")
    public ResponseEntity<Page<Movie>> listMovieByTag(@PathVariable String tag) {
        return ResponseEntity.ok(movieService.listMovieByTag(tag));
    }

}
