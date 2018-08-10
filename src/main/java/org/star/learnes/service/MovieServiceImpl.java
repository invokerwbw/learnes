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

/**
 * 电影接口实现类
 */
@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> listMovie() {
        Pageable pageable = PageRequest.of(0, 20);
        return movieRepository.findAll(pageable).getContent();
    }
}
