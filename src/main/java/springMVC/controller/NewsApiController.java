package springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springMVC.service.NewsApiClient;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsApiController {

    private final NewsApiClient newsApiClient;

    public NewsApiController(NewsApiClient newsApiClient) {
        this.newsApiClient = newsApiClient;
    }

    @GetMapping("/getTopNews")
    public List<String> getTopNews(@RequestParam String keyword, @RequestParam String lang) {
        return newsApiClient.getTopNews(keyword, lang);
    }

    @GetMapping("/getAllNews")
    public List<String> getAllNews(@RequestParam String keyword, @RequestParam String lang) {
        return newsApiClient.getAllNews(keyword, lang);
    }
}