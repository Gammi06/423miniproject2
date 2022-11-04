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

    @GetMapping("/s/recruits/{id}/info/companys")
    public CMRespDto<?> findApplyManage(@PathVariable Integer companysId) {
        return new CMRespDto<>(1, "성공", recruitsService.findApplyManage(companysId));
    }

    @GetMapping("/s/recruits/{id}/info/recommends")
    public CMRespDto<?> findRecommend(@PathVariable Integer companysId) {
        return new CMRespDto<>(1, "성공", recruitsService.findRecommend(companysId));
    }

    @GetMapping("/s/recruits/{id}/info/positions")
    public CMRespDto<?> findRecommendByPosition(@PathVariable Integer companysId, Integer positionsCodeId) {
        return new CMRespDto<>(1, "성공", recruitsService.findRecommendByPosition(companysId, positionsCodeId));
    }

}
