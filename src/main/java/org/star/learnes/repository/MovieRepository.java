package org.star.learnes.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.star.learnes.domain.Movie;

/**
 * 电影ES操作类
 */
public interface MovieRepository extends ElasticsearchRepository<Movie, String> {

}
