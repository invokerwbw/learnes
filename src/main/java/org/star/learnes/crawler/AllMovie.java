package org.star.learnes.crawler;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

@Gecco(matchUrl = "https://movie.douban.com/top250", pipelines = {"consolePipeline", "allMoviePipeline"})
public class AllMovie implements HtmlBean {

    @Request
    private HttpRequest request;

    @HtmlField(cssPath = ".grid_view li")
    private List<MovieBrief> details;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<MovieBrief> getDetails() {
        return details;
    }

    public void setDetails(List<MovieBrief> details) {
        this.details = details;
    }
}
