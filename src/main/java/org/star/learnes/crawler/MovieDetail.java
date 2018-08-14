package org.star.learnes.crawler;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "https://movie.douban.com/subject/{id}/", pipelines = {"consolePipeline", "movieDetailPipeline"})
public class MovieDetail implements HtmlBean {

    @RequestParameter
    private String id;

    @Text
    @HtmlField(cssPath = "#info > span:nth-child(1) > span.attrs > a")
    private String director;

    @Text
    @HtmlField(cssPath = ".year")
    private String year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
