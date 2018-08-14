package org.star.learnes.crawler;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class MovieBrief implements HtmlBean {

    @Text
    @HtmlField(cssPath = ".pic em")
    private Integer ranking;

    @Text
    @HtmlField(cssPath = "div.hd > a > span:nth-child(1)")
    private String title;

    @HtmlField(cssPath = ".bd p:nth-child(1)")
    private String info;

    @Text
    @HtmlField(cssPath = ".rating_num")
    private Float score;

    @Text
    @HtmlField(cssPath = ".quote span.inq")
    private String quote;

    @Href(click = true)
    @HtmlField(cssPath = "div.hd > a")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String urll) {
        this.url = urll;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}
