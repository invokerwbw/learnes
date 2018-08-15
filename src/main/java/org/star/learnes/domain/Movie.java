package org.star.learnes.domain;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
     * 排名
     */
    private Integer ranking;

    /**
     * 名称
     */
    private String title;

    /**
     * 导演
     */
    private List<String> director;

    /**
     * 主演
     */
    @Field(type = FieldType.Keyword)
    private List<String> starring;

    /**
     * 年份
     */
    private String year;

    /**
     * 标签
     */
    @Field(type = FieldType.Keyword)
    private List<String> tag;

    /**
     * 豆瓣评分
     */
    private Float score;

    /**
     * 引用
     */
    private String quote;

    /**
     * 豆瓣链接地址
     */
    private String url;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public List<String> getDirector() {
        return director;
    }

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public List<String> getStarring() {
        return starring;
    }

    public void setStarring(List<String> starring) {
        this.starring = starring;
    }
}
