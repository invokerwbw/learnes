package org.star.learnes.crawler;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

@Gecco(matchUrl = "https://movie.douban.com/subject/{id}/", pipelines = {"consolePipeline", "movieDetailPipeline"})
public class MovieDetail implements HtmlBean {

    @RequestParameter
    private String id;

    @Text
    @HtmlField(cssPath = "#info > span:nth-child(1) > span.attrs > a")
    private List<String> directors;

    @Text
    @HtmlField(cssPath = "[rel='v:starring']")
    private List<String> starring;

    @Text
    @HtmlField(cssPath = ".year")
    private String year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getStarring() {
        return starring;
    }

    public void setStarring(List<String> starring) {
        this.starring = starring;
    }
}
