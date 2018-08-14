package org.star.learnes.crawler;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.star.learnes.domain.Movie;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@PipelineName("allMoviePipeline")
public class AllMoviePipeline implements Pipeline<AllMovie> {
    @Override
    public void process(AllMovie allMovie) {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8080/movie");
        post.setHeader("Content-type", "application/json");

        List<MovieBrief> movieBriefs = allMovie.getDetails();
        for (MovieBrief movieBrief : movieBriefs) {

            Integer id = movieBrief.getId();
            String title = movieBrief.getTitle();
            String quote = movieBrief.getQuote();
            Float score = movieBrief.getScore();
            String url = movieBrief.getUrl();

            String director = null;
            String year = null;
            List<String> tag = null;
            String info = movieBrief.getInfo();
            if (!"".equals(info)) {
                String[] infos = info.split("<br>");
                if (infos != null && infos.length >= 2) {
                    director = infos[0].split(" ")[1];
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
            movie.setTitle(title);
            movie.setQuote(quote);
            movie.setDirector(director);
            movie.setTag(tag);
            movie.setYear(year);
            movie.setScore(score);
            movie.setUrl(url);
//            System.out.println("Movie : " + JSON.toJSONString(movie));

            StringEntity requestEntity = new StringEntity(JSON.toJSONString(movie), "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            post.setEntity(requestEntity);
            try {
                CloseableHttpResponse response = client.execute(post);
                String responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("save movie : " + responseContent);
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
