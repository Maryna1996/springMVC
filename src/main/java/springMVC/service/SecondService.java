package springMVC.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SecondService {

    private static final Logger logger = LoggerFactory.getLogger(SecondService.class);

    private final RestTemplate restTemplate;

    @Value("${news-api-service.url}")
    private String newsApiServiceUrl;

    public SecondService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void displayProcessedNews() {
        String url = "http://localhost:8181/proxy/getAllNews?keyword=example&lang=en";
        String[] processedNews = restTemplate.getForObject(url, String[].class);

        for (String news : processedNews) {
            logger.info(news);
        }
    }
}
