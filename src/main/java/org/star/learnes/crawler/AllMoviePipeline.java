package org.star.learnes.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

import java.util.Arrays;
import java.util.List;

@PipelineName("allMoviePipeline")
public class AllMoviePipeline implements Pipeline<AllMovie> {
    @Override
    public void process(AllMovie allMovie) {

        List<MovieBrief> movieBriefs = allMovie.getDetails();
        for (MovieBrief movieBrief : movieBriefs) {
            System.out.println("ID : " + movieBrief.getId());
            System.out.println("Titile : " + movieBrief.getTitle());
            System.out.println("Quote : " + movieBrief.getQuote());
            System.out.println("Score : " + movieBrief.getRatingNum());

            String director = null;
            String year = null;
            List<String> tag = null;
            String info = movieBrief.getInfo();
            if (!"".equals(info)) {
                String[] infos = info.split("\\.\\.\\.");
                if (infos != null && infos.length == 2) {
                    director = infos[0].split(" ")[1];
                    String[] others = infos[1].split("/");
                    if (others != null && others.length == 3) {
                        year = others[0];
                        String[] tags = others[2].split(" ");
                        tag = Arrays.asList(tags);
                    }
                }
                System.out.println("Director : " + director);
                System.out.println("Year : " + year);
                System.out.println("Tag : " + tag);
            }
        }

    }

    public static void main(String[] args) {
        GeccoEngine.create()
                //Gecco搜索的包路径
                .classpath("org.star.learnes.crawler")
                //开始抓取的页面地址
                .start("https://movie.douban.com/top250")
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                .start();
    }
}
