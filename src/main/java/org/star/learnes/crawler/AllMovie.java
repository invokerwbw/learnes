package org.star.learnes.crawler;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

@Gecco(matchUrl = "https://movie.douban.com/top250?start={start}&filter=", pipelines = {"consolePipeline", "allMoviePipeline"})
public class AllMovie implements HtmlBean {

    @Request
    private HttpRequest request;

    @HtmlField(cssPath = ".grid_view li")
    private List<MovieBrief> details;

    @Text
    @HtmlField(cssPath = ".thispage")
    private int thisPage;

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

    public int getThisPage() {
        return thisPage;
    }

    public void setThisPage(int thisPage) {
        this.thisPage = thisPage;
    }
}
