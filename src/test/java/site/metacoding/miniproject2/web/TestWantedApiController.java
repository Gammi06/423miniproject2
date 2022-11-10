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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;
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

    @Autowired
    private ObjectMapper om;

    private MockHttpSession session;

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

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void findAllByLike_test() throws Exception {

        // given

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.get("/s/api/wanted/like")
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].title").value("프론트 개발자 구인"));

    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void findAllByPositionCodeId_test() throws Exception {

        // given
        Integer positionCodeId = 1;

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.get("/wanted/position/" + positionCodeId)
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].positionCodeName").value("백앤드개발자"));

    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void findAllByCompanyId_test() throws Exception {

        // given
        Integer companyId = 1;

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.get("/wanted/company/" + companyId)
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].companyName").value("이재모피자"));

    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void insertLike_test() throws Exception {

        // given
        Integer wantedId = 1;

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.post("/s/api/wanted/" + wantedId + "/like")
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.userId").value(1));
    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void deleteLike_test() throws Exception {

        // given
        Integer wantedId = 2;

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.delete("/s/api/wanted/" + wantedId + "/like")
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));

    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void insertApply_test() throws Exception {

        // given
        Integer wantedId = 9;
        Integer resumeId = 1;
        String applyUserReqDto = om.writeValueAsString(new ApplyUserReqDto(0, wantedId, resumeId));

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.post("/s/api/wanted/" + wantedId + "/apply/add")
                        .session(session)
                        .content(applyUserReqDto)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.resumeId").value(1));

    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void likesform_test() throws Exception {

        Integer Id = 1;

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.get("/s/mypage/likes")
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println("debugggg:" + mvcResult.getResponse().getContentAsString());

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
    }

}
