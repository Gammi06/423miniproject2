package site.metacoding.miniproject2.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.config.MyBatisConfig;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;
import site.metacoding.miniproject2.service.TestWantedsService;

@Slf4j
@Import(MyBatisConfig.class) // MyBatisTest가 MyBatisConfig를 못읽음
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실DB사용
@WebAppConfiguration
public class TestWantedApiController {

    private TestWantedsService wantedsService = new TestWantedsService();
    // private final LikesService likesService;
    // private final ApplyService applyService;

    @Test
    public void test() {
        // give
        int num = 3;
        // when
        int num2 = 2;
        // then
        assertEquals(2, num2);
    }

    @Test
    @GetMapping("/api/wanted/{wantedId}")
    public WantedDetailRespDto findById(@PathVariable Integer wantedId) {
        return wantedsService.findById(wantedId);
    }

    @Test
    @GetMapping("/s/api/wanted/{userId}/like")
    public List<WantedListRespDto> findAllByLike(@PathVariable Integer userId) {
        return wantedsService.findAllByLike(userId);
    }

    @Test
    @GetMapping("/api/wanted/position/{positionCodeName}")
    public List<WantedListRespDto> findAllByPositionCodeName(@PathVariable String positionCodeName) {
        return wantedsService.findAllByPositionCodeName(positionCodeName);
    }

    @Test
    @GetMapping("/api/wanted/position/{companyId}")
    public List<WantedListRespDto> findAllByCompanyId(@PathVariable Integer companyId) {
        return wantedsService.findAllByCompanyId(companyId);
    }

    @Test
    @PostMapping("/s/api/wanted/{userId}/like")
    public void wantedInsertLike(@PathVariable Integer userId) {
        // userId에 유저 아이디값 넣어주기
        wantedsService.wantedInsertLike(userId);
    }

    @Test
    @PostMapping("/s/api/wanted/{userId}/apply")
    public void wantedInsertApply(@PathVariable Integer userId) {
        // userId에 유저 아이디값 넣어주기
        wantedsService.wantedInsertApply(userId);
    }
}
