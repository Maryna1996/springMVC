package springMVC.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import springMVC.confugurations.NewsConfig;
import java.util.List;

@Service
public class NewsApiClient {

    private final RestTemplate restTemplate;

    public NewsApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getTopNews(String keyWord, String lang) {
        String url = UriComponentsBuilder.fromUriString(NewsConfig.NEWS_API_SERVICE_HOST)
                .path("getTopNews")
                .queryParam("keyword", keyWord)
                .queryParam("lang", lang)
                .toUriString();

        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});
        List<String> titles = responseEntity.getBody();

        // Adding "Glory to Ukraine" to each title
        titles.replaceAll(title -> title + " Glory to Ukraine");
        return titles;
    }

    public List<String> getAllNews(String keyWord, String lang) {
        String url = UriComponentsBuilder.fromUriString(NewsConfig.NEWS_API_SERVICE_HOST)
                .path("getAllNews")
                .queryParam("keyword", keyWord)
                .queryParam("lang", lang)
                .toUriString();

        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});
        List<String> titles = responseEntity.getBody();

        // Adding "Glory to Ukraine" to each title
        titles.replaceAll(title -> title + " Glory to Ukraine");
        return titles;
    }
}