package site.metacoding.miniproject2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.service.RecruitsService;

@RequiredArgsConstructor
@RestController
public class RecruitsApiController {

    private final RecruitsService recruitsService;

    @GetMapping("/s/recruits/{id}/companys")
    public CMRespDto<?> findApplyManage(@PathVariable Integer id) {
        return new CMRespDto<>(1, "성공", recruitsService.findApplyManage(id));
    }

    @GetMapping("/s/recruits/{id}/recommends")
    public CMRespDto<?> findRecommend(@PathVariable Integer id) {
        return new CMRespDto<>(1, "성공", recruitsService.findRecommend(id));
    }

    @GetMapping("/s/recruits/{id}/positions")
    public CMRespDto<?> findRecommendByPosition(@PathVariable Integer id, Integer positionsCodeId) {
        return new CMRespDto<>(1, "성공", recruitsService.findRecommendByPosition(id, positionsCodeId));
    }

}
