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
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsSaveReqDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.util.SHA256;

@Slf4j
@ActiveProfiles("test")
@Sql("classpath:truncate.sql")
@AutoConfigureMockMvc // MockMvc Ioc 컨테이너에 등록
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) // 가짜 환경으로 실행
public class TestWantedApiController {

    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private WantedsDao wantedsDao;

    @Autowired
    private SHA256 sha256;

    private MockHttpSession session;

    @BeforeEach
    public void dataInit() {
        WantedsSaveReqDto wantedsSaveReqDto = new WantedsSaveReqDto();
        wantedsSaveReqDto.setWantedTitle("test1");
        wantedsSaveReqDto.setWantedDetail("test");
        wantedsSaveReqDto.setPositionCodeId(1);
        wantedsSaveReqDto.setCareerCodeId(1);
        wantedsSaveReqDto.setPay("3000");
        wantedsDao.save(wantedsSaveReqDto);
    }

    @Test
    void findById_test() throws Exception {

        // given
        Integer id = 1;

        // when
        WantedDetailRespDto wantedDetailRespDto = wantedsDao.findById(id);

        // then
        wantedDetailRespDto.getTitle().equals("test1");
    }
}
