package org.star.learnes.crawler;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.star.learnes.domain.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PipelineName("allMoviePipeline")
public class AllMoviePipeline implements Pipeline<AllMovie> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllMoviePipeline.class);

    @Override
    public void process(AllMovie allMovie) {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut put = new HttpPut("http://localhost:8080/movie");
        put.setHeader("Content-type", "application/json");

        List<MovieBrief> movieBriefs = allMovie.getDetails();
        for (MovieBrief movieBrief : movieBriefs) {

            String id = null;
            Integer ranking = movieBrief.getRanking();
            String title = movieBrief.getTitle();
            String quote = movieBrief.getQuote();
            Float score = movieBrief.getScore();
            String url = movieBrief.getUrl();
            if (url != null && !"".equals(url)) {
                id = url.replace("https://", "").split("/")[2];
            }

            List<String> directors = new ArrayList<String>();
            String director = null;
            String year = null;
            List<String> tag = null;
            String info = movieBrief.getInfo();
            if (!"".equals(info)) {
                String[] infos = info.split("<br>");
                if (infos != null && infos.length >= 2) {
                    director = infos[0].split(" ")[1];
                    directors.add(director);
                    String[] others = infos[1].replace("&nbsp;", " ").split("/");
                    if (others != null && others.length >= 3) {
                        year = others[0].trim();
                        String[] tags = others[others.length - 1].trim().split(" ");
                        tag = Arrays.asList(tags);
                    }
                }
            }

            Movie movie = new Movie();
            movie.setId(id);
            movie.setRanking(ranking);
            movie.setTitle(title);
            movie.setQuote(quote);
            movie.setDirector(directors);
            movie.setTag(tag);
            movie.setYear(year);
            movie.setScore(score);
            movie.setUrl(url);
//            LOGGER.info("Movie : " + JSON.toJSONString(movie));

            StringEntity requestEntity = new StringEntity(JSON.toJSONString(movie), "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            put.setEntity(requestEntity);
            try {
                CloseableHttpResponse response = client.execute(put);
                String responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");
                LOGGER.info("save movie : " + responseContent);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        HttpRequest request = allMovie.getRequest();
        int thisPage = allMovie.getThisPage();
        if (thisPage != 0 && thisPage < 10) {
            String thisUrl = request.getUrl();
            String nextUrl = StringUtils.replaceOnce(thisUrl, "start=" + (thisPage - 1) * 25, "start=" + thisPage * 25);
            DeriveSchedulerContext.into(request.subRequest(nextUrl));
        }

    }

    public static void main(String[] args) {
        GeccoEngine.create()
                //Gecco搜索的包路径
                .classpath("org.star.learnes.crawler")
                //开始抓取的页面地址
                .start("https://movie.douban.com/top250?start=0&filter=")
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                .start();
    }
}
