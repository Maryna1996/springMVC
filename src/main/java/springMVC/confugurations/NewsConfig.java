package springMVC.confugurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NewsConfig {

    public static final String NEWS_API_SERVICE_HOST = "http://localhost:8181/proxy/";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getNewsApiServiceHost() {
        return NEWS_API_SERVICE_HOST;
    }
}
