package org.star.learnes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.star.learnes.domain.Movie;
import org.star.learnes.repository.MovieRepository;

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
    public Movie modifyMovie(Movie movie) {
        String id = movie.getId();
        Optional<Movie> old = movieRepository.findById(id);
        if (old.isPresent()) {
            Movie oldMovie = old.get();
            oldMovie.setYear(movie.getYear());
            oldMovie.setDirector(movie.getDirector());
            return movieRepository.save(oldMovie);
        } else {
            return null;
        }
    }

    @Override
    public Page<Movie> listMovie() {
        Pageable pageable = PageRequest.of(DEFAULT_PAGE, DEFAULT_SIZE, Sort.by("ranking"));
        return movieRepository.findAll(pageable);
    }

    @Override
    public Page<Movie> listMovie(int page, int size) {
        if (page < 0) {
            LOGGER.warn("page : " + page + " less than zero");
            page = DEFAULT_PAGE;
        }
        if (size < 0) {
            LOGGER.warn("size : " + size + " less than zero");
            size = DEFAULT_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("ranking"));
        return movieRepository.findAll(pageable);
    }

    @Override
    public Page<Movie> listMovieByYear(String year, int page, int size) {
        if (page < 0) {
            LOGGER.warn("page : " + page + " less than zero");
            page = DEFAULT_PAGE;
        }
        if (size < 0) {
            LOGGER.warn("size : " + size + " less than zero");
            size = DEFAULT_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("ranking"));
        return movieRepository.findMoviesByYear(year, pageable);
    }

    @Override
    public Page<Movie> listMovieByYear(String year) {
        Pageable pageable = PageRequest.of(DEFAULT_PAGE, DEFAULT_SIZE, Sort.by("ranking"));
        return movieRepository.findMoviesByYear(year, pageable);
    }

    @Override
    public Page<Movie> listMovieByTitle(String title, int page, int size) {
        if (page < 0) {
            LOGGER.warn("page : " + page + " less than zero");
            page = DEFAULT_PAGE;
        }
        if (size < 0) {
            LOGGER.warn("size : " + size + " less than zero");
            size = DEFAULT_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("ranking"));
        return movieRepository.findMoviesByTitle(title, pageable);
    }

    @Override
    public Page<Movie> listMovieByTitle(String title) {
        Pageable pageable = PageRequest.of(DEFAULT_PAGE, DEFAULT_SIZE, Sort.by("ranking"));
        return movieRepository.findMoviesByTitle(title, pageable);
    }

    @Override
    public Page<Movie> listMovieByDirector(String director, int page, int size) {
        if (page < 0) {
            LOGGER.warn("page : " + page + " less than zero");
            page = DEFAULT_PAGE;
        }
        if (size < 0) {
            LOGGER.warn("size : " + size + " less than zero");
            size = DEFAULT_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("ranking"));
        return movieRepository.findMoviesByDirector(director, pageable);
    }

    @Override
    public Page<Movie> listMovieByDirector(String director) {
        Pageable pageable = PageRequest.of(DEFAULT_PAGE, DEFAULT_SIZE, Sort.by("ranking"));
        return movieRepository.findMoviesByDirector(director, pageable);
    }

    @Override
    public Page<Movie> listMovieByTag(String tag, int page, int size) {
        if (page < 0) {
            LOGGER.warn("page : " + page + " less than zero");
            page = DEFAULT_PAGE;
        }
        if (size < 0) {
            LOGGER.warn("size : " + size + " less than zero");
            size = DEFAULT_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("ranking"));
        return movieRepository.findMoviesByTag(tag, pageable);
    }

    @Override
    public Page<Movie> listMovieByTag(String tag) {
        Pageable pageable = PageRequest.of(DEFAULT_PAGE, DEFAULT_SIZE, Sort.by("ranking"));
        return movieRepository.findMoviesByTag(tag, pageable);
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

    @Override
    public Movie getMovieByRanking(Integer ranking) {
        Optional<Movie> movie = movieRepository.findMovieByRanking(ranking);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            return null;
        }
    }
}
