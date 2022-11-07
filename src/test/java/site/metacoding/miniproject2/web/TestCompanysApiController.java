package site.metacoding.miniproject2.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockCookie;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.domain.companys.CompanysDao;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.util.SHA256;

@Slf4j
@ActiveProfiles("test")
@Sql("classpath:truncate.sql")
@Transactional
@AutoConfigureMockMvc // MockMvc Ioc 컨테이너에 등록
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) // 가짜 환경으로 실행
public class TestCompanysApiController {

    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    @Autowired
    private MockMvc mvc;
    @Autowired
    private CompanysDao companysDao;

    private MockHttpSession session;
    private MockCookie cookie;

    // @BeforeEach
    // public void dataInit() {
    // session = new MockHttpSession();
    // SessionUsers pricincipal = new SessionUsers(1, " 일반", "garam1234");
    // String JwtToken = CreateJWTToken.createToken(pricincipal); // Authorization
    // cookie = new MockCookie("Authorization", JwtToken);
    // }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    void findById_test() throws Exception {

        // given
        Integer companysId = 1;

        // when

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/" + companysId)
                .accept(APPLICATION_JSON)
                .session(session));
        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.title").value("서버개발자 구인"));

    }
}
