package org.star.learnes.crawler;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class MovieBrief implements HtmlBean {

    @Text
    @HtmlField(cssPath = ".pic em")
    private String id;

    @Text
    @HtmlField(cssPath = "div.hd > a > span:nth-child(1)")
    private String title;

    @HtmlField(cssPath = ".bd p:nth-child(1)")
    private String info;

    @Text
    @HtmlField(cssPath = ".rating_num")
    private String score;

    @Text
    @HtmlField(cssPath = ".quote span.inq")
    private String quote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
