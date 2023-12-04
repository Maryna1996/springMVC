package springMVCtesting.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import springMVC.service.SecondService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecondServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SecondService secondService;

    @Test
    public void testDisplayProcessedNews() {
        when(restTemplate.getForObject(eq("http://localhost:8181/proxy/getAllNews?keyword=example&lang=en"), eq(String[].class)))
                .thenReturn(new String[]{"Processed News 1", "Processed News 2"});

        secondService.displayProcessedNews();

        verify(restTemplate).getForObject(eq("http://localhost:8181/proxy/getAllNews?keyword=example&lang=en"), eq(String[].class));
    }
}
