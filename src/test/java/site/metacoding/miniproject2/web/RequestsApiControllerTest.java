package site.metacoding.miniproject2.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import site.metacoding.miniproject2.service.RequestsService;

@ActiveProfiles("test")
@Sql("classpath:truncate.sql")
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RequestsApiControllerTest {

    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    @Autowired
    private TestRestTemplate rt;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private RequestsService requestsService;

    private static HttpHeaders headers;

    @BeforeAll
    public static void init() {
        headers = new HttpHeaders(); // http 요청 header에 필요
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void findRequests_test() throws Exception {
        // given
        Integer id = 1;
        String keyword = "";

        // when
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = rt.exchange("/proposal" + id, HttpMethod.GET,
                request, String.class);
        // then
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        DocumentContext dc = JsonPath.parse(response.getBody());
        // System.out.println(dc.jsonString());
        Integer code = dc.read("$.code");
        Assertions.assertEquals(code, 1);
    }
}
