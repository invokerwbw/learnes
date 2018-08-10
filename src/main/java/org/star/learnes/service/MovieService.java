package org.star.learnes.service;

import org.star.learnes.domain.Movie;

import java.util.List;

/**
 * 电影接口类
 */
public interface MovieService {

    /**
     * 保存电影
     *
     * @param movie
     * @return
     */
    Movie saveMovie(Movie movie);

    /**
     * 获取电影列表
     *
     * @return
     */
    List<Movie> listMovie();

}
