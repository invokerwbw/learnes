package org.star.learnes.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

import java.util.List;

@PipelineName("allMoviePipeline")
public class AllMoviePipeline implements Pipeline<AllMovie> {
    @Override
    public void process(AllMovie allMovie) {

        List<MovieBrief> movieBriefs = allMovie.getDetails();
        for (MovieBrief movieBrief : movieBriefs) {
            System.out.println(movieBrief.getTitle());
            System.out.println(movieBrief.getInfo());
            System.out.println(movieBrief.getQuote());
            System.out.println(movieBrief.getRatingNum());
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
