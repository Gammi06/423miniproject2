package site.metacoding.miniproject2.web;

import java.net.http.HttpResponse;

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
import site.metacoding.miniproject2.domain.companys.CompanysDao;
import site.metacoding.miniproject2.domain.users.UsersDao;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.SessionUsers;

@Slf4j
@ActiveProfiles("test") // 테스트 어플리케이션 실행
@Sql("classpath:truncate.sql")
@Transactional
@AutoConfigureMockMvc // MockMvc Ioc 컨테이너에 등록 실제가 아닌 가짜
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) // MOCK은 가짜 환경임
public class TestCompanysApiController {

    // header json
    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    private static final Object CompanysInsertReqDto = null;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CompanysDao companysDao;

    @Autowired
    private UsersDao usersDao;

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
    public void findByCompanyIdInfo_test() throws Exception {

        // given
        Integer companyId = 1;

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.get("/companys/info/" + companyId)
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.companyName").value("이재모피자"));
    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void insertSubcribes_test() throws Exception {

        // given

        // when

        // then
    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void deleteSubcribes_test() throws Exception {

        // given

        // when

        // then
    }

    /* 지원 작업 시작! */
    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void insert_test() throws Exception {

        // given
        Integer id = 1;
        CompanysInsertReqDto companysInsertReqDto = new CompanysInsertReqDto();
        companysInsertReqDto.setId(6);
        companysInsertReqDto.setCompanyName("고구마 농장");
        companysInsertReqDto.setAddress("부산 노포동");
        companysInsertReqDto.setEmail("ddd@nate.com");
        companysInsertReqDto.setCompanyNumber("1234567897");
        companysInsertReqDto.setRegionCodeName("부산");
        companysInsertReqDto.setIntro("고구마 맛탕 맛집");
        companysInsertReqDto.setYears(2021);
        companysInsertReqDto.setUsersId(1);
        String body = om.writeValueAsString(CompanysInsertReqDto);

        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.post("/s/api/companys/" + id + "/add")
                        .content(body)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON));

        // then
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println("디버그 : " + mvcResult.getResponse().getContentAsString());
        System.out.println("debugggg:" + mvcResult.getResponse().getStatus());

        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        // 유저 아이디
    }
    // 회사서비스 가입 테스트 코드

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void updateCompanyId_test() throws Exception {

        // given
        Integer companysId = 1;
        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.delete("/s/api/companys/" + companysId)
                        .accept(APPLICATION_JSON)
                        .session(session));
        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.companyName").value("남해어장횟집"));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.address").value("경상남도 남해군 상주면 남해대로675번길 76"));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("fish@nate.com"));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.regionCodeName").value("남해"));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.memberCount").value(11));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.usersId").value(1));// 유저 아이디
        // 회사정보 엡데이트 테스트
    }

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void deleteCompanysId_test() throws Exception {

        // given
        Integer companysId = 1;
        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.delete("/s/api/companys" + companysId + "/delete")
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));

    }// 회사서비스 삭제 테스트

    @Sql(scripts = "classpath:createTest.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void subscribesform_test() throws Exception {

        // given
        Integer userId = 1;
        // when
        ResultActions resultActions = mvc.perform(
                MockMvcRequestBuilders.delete("/s/mypage/" + userId + "/subscribes")
                        .accept(APPLICATION_JSON)
                        .session(session));

        // then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.data.userId").value(1));

    }

}
