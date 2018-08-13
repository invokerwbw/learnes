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
     * 获取电影列表（使用默认分页）
     *
     * @return
     */
    List<Movie> listMovie();

    /**
     * 获取电影列表（带分页信息）
     *
     * @param page
     * @param size
     * @return
     */
    List<Movie> listMovie(int page, int size);

    /**
     * 根据ID获取指定电影
     *
     * @return
     */
    Movie getMovieById(String id);

}
