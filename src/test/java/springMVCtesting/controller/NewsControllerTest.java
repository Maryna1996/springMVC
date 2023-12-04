package springMVCtesting.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import springMVC.service.NewsApiClient;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NewsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NewsApiClient newsApiClient;

    @Test
    public void testGetTopNews() throws Exception {
        List<String> News = Arrays.asList(" News 1", " News 2");
        Mockito.when(newsApiClient.getTopNews("Ukraine", "en")).thenReturn(News);

        mvc.perform(get("/news/getTopNews?keyword=Ukraine&lang=en"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0]").value(" News 1"))
                .andExpect(jsonPath("$[1]").value(" News 2"));
    }

    @Test
    public void testGetAllNews() throws Exception {
        List<String> News = Arrays.asList(" News 3", " News 4");
        Mockito.when(newsApiClient.getAllNews("Ukraine", "en")).thenReturn(News);

        mvc.perform(get("/news/getAllNews?keyword=Ukraine&lang=en"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0]").value(" News 3"))
                .andExpect(jsonPath("$[1]").value(" News 4"));
    }
}
