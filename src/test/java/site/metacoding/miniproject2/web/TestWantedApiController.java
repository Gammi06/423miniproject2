package site.metacoding.miniproject2.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.SessionUsers;

@Slf4j
@ActiveProfiles("test") // 테스트 어플리케이션 실행
@Sql("classpath:truncate.sql")
@Transactional
@AutoConfigureMockMvc // MockMvc Ioc 컨테이너에 등록 실제가 아닌 가짜
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) // MOCK은 가짜 환경임
public class TestWantedApiController {

    // header json
    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    @Autowired
    private MockMvc mvc;

    private MockHttpSession session;

    @Autowired
    private WantedsDao wantedsDao;

    @BeforeEach
    public void sessionInit() {
        session = new MockHttpSession();
        session.setAttribute("principal", SessionUsers.builder()
                .id(1)
                .userId("garam1234")
                .role("일반")
                .build());
    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void findById_test() throws Exception {

        // given
        Integer wantedId = 1;

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.get("/wanted/" + wantedId)
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.title").value("서버 개발자 구인"));
    }
}
