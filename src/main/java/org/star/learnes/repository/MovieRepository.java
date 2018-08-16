package org.star.learnes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.star.learnes.domain.Movie;

import java.util.Optional;

/**
 * 电影ES操作类
 */
public interface MovieRepository extends ElasticsearchRepository<Movie, String> {

    /**
     * 按名称获取电影列表
     *
     * @param title
     * @param pageable
     * @return
     */
    Page<Movie> findMoviesByTitle(String title, Pageable pageable);

    /**
     * 按导演获取电影列表
     *
     * @param director
     * @param pageable
     * @return
     */
    Page<Movie> findMoviesByDirector(String director, Pageable pageable);

    /**
     * 按主演获取电影列表
     *
     * @param starring
     * @param pageable
     * @return
     */
    Page<Movie> findMoviesByStarring(String starring, Pageable pageable);

    /**
     * 按年份获取电影列表
     *
     * @param year
     * @param pageable
     * @return
     */
    Page<Movie> findMoviesByYear(String year, Pageable pageable);

    /**
     * 按标签获取电影列表
     *
     * @param tag
     * @param pageable
     * @return
     */
    Page<Movie> findMoviesByTag(String tag, Pageable pageable);

    /**
     * 根据排名获取指定电影
     *
     * @param ranking
     * @return
     */
    Optional<Movie> findMovieByRanking(Integer ranking);

}
