package org.star.learnes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.star.learnes.domain.Movie;
import org.star.learnes.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

/**
 * 电影接口实现类
 */
@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_SIZE = 25;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> listMovie() {
        Pageable pageable = PageRequest.of(DEFAULT_PAGE, DEFAULT_SIZE);
        return movieRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Movie> listMovie(int page, int size) {
        if (page < 0) {
            page = DEFAULT_PAGE;
        }
        if (size < 0) {
            size = DEFAULT_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size);
        return movieRepository.findAll(pageable).getContent();
    }

    @Override
    public Movie getMovieById(String id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            return null;
        }
    }
}
