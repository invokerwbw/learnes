package org.star.learnes.service;

import org.springframework.data.domain.Page;
import org.star.learnes.domain.Movie;

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
    Page<Movie> listMovie();

    /**
     * 获取电影列表（带分页信息）
     *
     * @param page
     * @param size
     * @return
     */
    Page<Movie> listMovie(int page, int size);

    /**
     * 根据ID获取指定电影
     *
     * @return
     */
    Movie getMovieById(Integer id);

}
