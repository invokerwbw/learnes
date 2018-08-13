package org.star.learnes.crawler;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class MovieBrief implements HtmlBean {

    @Text
    @HtmlField(cssPath = "div.hd > a > span:nth-child(1)")
    private String title;

    @Text
    @HtmlField(cssPath = ".bd p")
    private String info;

    @Text
    @HtmlField(cssPath = ".rating_num")
    private String ratingNum;

    @Text
    @HtmlField(cssPath = ".quote span.inq")
    private String quote;

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

    public String getRatingNum() {
        return ratingNum;
    }

    public void setRatingNum(String ratingNum) {
        this.ratingNum = ratingNum;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
