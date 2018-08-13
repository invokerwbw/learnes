package org.star.learnes.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.List;

/**
 * 电影实体类
 */
@Document(indexName = "movies", type = "movie")
public class Movie implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 名称
     */
    private String title;

    /**
     * 导演
     */
    private String director;

    /**
     * 年份
     */
    private String year;

    /**
     * 标签
     */
    private List<String> tag;

    /**
     * 豆瓣评分
     */
    private Float score;

    /**
     * 引用
     */
    private String quote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
