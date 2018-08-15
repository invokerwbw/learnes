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
     * 修改电影
     *
     * @param movie
     * @return
     */
    Movie modifyMovie(Movie movie);

    /**
     * 获取电影列表（使用默认分页）
     *
     * @return
     */
    Page<Movie> listMovie();

    /**
     * 获取电影列表（需分页参数）
     *
     * @param page
     * @param size
     * @return
     */
    Page<Movie> listMovie(int page, int size);

    /**
     * 按年份获取电影列表（需分页参数）
     *
     * @param year
     * @param page
     * @param size
     * @return
     */
    Page<Movie> listMovieByYear(String year, int page, int size);

    /**
     * 按年份获取电影列表（使用默认分页）
     *
     * @param year
     * @return
     */
    Page<Movie> listMovieByYear(String year);

    /**
     * 按名称获取电影列表（需分页参数）
     *
     * @param title
     * @param page
     * @param size
     * @return
     */
    Page<Movie> listMovieByTitle(String title, int page, int size);

    /**
     * 按名称获取电影列表（使用默认分页）
     *
     * @param title
     * @return
     */
    Page<Movie> listMovieByTitle(String title);

    /**
     * 按导演获取电影列表（需分页参数）
     *
     * @param director
     * @param page
     * @param size
     * @return
     */
    Page<Movie> listMovieByDirector(String director, int page, int size);

    /**
     * 按导演获取电影列表（使用默认分页）
     *
     * @param director
     * @return
     */
    Page<Movie> listMovieByDirector(String director);

    /**
     * 按标签获取电影列表（需分页参数）
     *
     * @param tag
     * @param page
     * @param size
     * @return
     */
    Page<Movie> listMovieByTag(String tag, int page, int size);

    /**
     * 按标签获取电影列表（使用默认分页）
     *
     * @param tag
     * @return
     */
    Page<Movie> listMovieByTag(String tag);

    /**
     * 根据ID获取指定电影
     *
     * @return
     */
    Movie getMovieById(String id);

    /**
     * 根据排名获取指定电影
     *
     * @param ranking
     * @return
     */
    Movie getMovieByRanking(Integer ranking);

}
