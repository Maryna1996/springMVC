package springMVCtesting.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import springMVC.service.NewsApiClient;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewsServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NewsApiClient newsApiClient;

    @Test
    public void testGetTopNews() {
        String keyword = "Ukraine";
        String lang = "en";
        String url = "http://localhost:8181/proxy/getTopNews?keyword=Ukraine&lang=en";
        List<String> News = Arrays.asList(" News 1", " News 2");

        when(restTemplate.exchange(
                eq(url),
                eq(HttpMethod.GET),
                eq(null),
                any(ParameterizedTypeReference.class)))
                .thenReturn(new ResponseEntity<>(News, HttpStatus.OK));

        List<String> result = newsApiClient.getTopNews(keyword, lang);

        assertThat(result, hasSize(2));
        assertThat(result.get(0), org.hamcrest.Matchers.is(" News 1 Glory to Ukraine"));
        assertThat(result.get(1), org.hamcrest.Matchers.is(" News 2 Glory to Ukraine"));
    }

    @Test
    public void testGetAllNews() {
        String keyword = "Ukraine";
        String lang = "en";
        String url = "http://localhost:8181/proxy/getAllNews?keyword=Ukraine&lang=en";
        List<String> News = Arrays.asList(" News 3", " News 4");

        when(restTemplate.exchange(
                eq(url),
                eq(HttpMethod.GET),
                eq(null),
                any(ParameterizedTypeReference.class)))
                .thenReturn(new ResponseEntity<>(News, HttpStatus.OK));

        List<String> result = newsApiClient.getAllNews(keyword, lang);

        assertThat(result, hasSize(2));
        assertThat(result.get(0), org.hamcrest.Matchers.is(" News 3 Glory to Ukraine"));
        assertThat(result.get(1), org.hamcrest.Matchers.is(" News 4 Glory to Ukraine"));
    }
}
