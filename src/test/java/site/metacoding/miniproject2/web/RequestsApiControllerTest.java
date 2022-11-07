package site.metacoding.miniproject2.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import site.metacoding.miniproject2.domain.users.Users;
import site.metacoding.miniproject2.service.RequestsService;
import site.metacoding.miniproject2.service.UsersService;
import site.metacoding.miniproject2.util.SHA256;

@ActiveProfiles("test")
@Sql("classpath:truncate.sql")
@Transactional // 트랜잭션 안붙이면 영속성 컨텍스트에서 DB로 flush 안됨 (Hibernate 사용시)
@AutoConfigureMockMvc // MockMvc Ioc 컨테이너에 등록
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class RequestsApiControllerTest {

    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private RequestsService requestsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private SHA256 sha256;

    private MockHttpSession session;

    private static HttpHeaders headers;

    @BeforeEach
    public void sessionInit() {
        session = new MockHttpSession();
        Users users = Users.builder().id(1).userName("ssar").build();
        // session.setAttribute("sessionUser", new SessionUser(users));
    }

    @BeforeEach
    public void dataInit() {
        String encPassword = sha256.encrypt("1234");
        Users users = Users.builder().userName("ssar").userPassword(encPassword).build();
        // Users usersPS = usersService.insert(users);
    }

    @Test
    public void findRequests_test() throws Exception {
        // given
        Integer id = 1;
        String keyword = "";

    }

    @Test
    public void findById_test() throws Exception {
        // given
        Long id = 1L;

        // when
        ResultActions resultActions = mvc
                .perform(MockMvcRequestBuilders.get("/board/" + id).accept(APPLICATION_JSON));

        // then
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println("디버그 : " + mvcResult.getResponse().getContentAsString());
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.title").value("스프링1강"));
    }
}
