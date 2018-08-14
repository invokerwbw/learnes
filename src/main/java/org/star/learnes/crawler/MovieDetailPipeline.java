package org.star.learnes.crawler;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.star.learnes.domain.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@PipelineName("movieDetailPipeline")
public class MovieDetailPipeline implements Pipeline<MovieDetail> {
    @Override
    public void process(MovieDetail movieDetail) {

        List<String> directors = new ArrayList<String>();
        String id = movieDetail.getId();
        String director = movieDetail.getDirector();
        String year = movieDetail.getYear();

        if (year != null) {
            year = year.replace("(", "").replace(")", "");
        }
        if (director != null) {
            String[] directorArray = director.split("/");
            for (String text : directorArray) {
                directors.add(text.trim());
            }
        }

        Movie movie = new Movie();
        movie.setId(id);
        movie.setDirector(directors);
        movie.setYear(year);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8080/movie");
        post.setHeader("Content-type", "application/json");

        StringEntity requestEntity = new StringEntity(JSON.toJSONString(movie), "utf-8");
        requestEntity.setContentEncoding("UTF-8");
        post.setEntity(requestEntity);
        try {
            CloseableHttpResponse response = client.execute(post);
            String responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println("modify movie : " + responseContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
