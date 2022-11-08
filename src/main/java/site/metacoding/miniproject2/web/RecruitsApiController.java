package site.metacoding.miniproject2.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.UsersRespDto.AuthRespDto;
import site.metacoding.miniproject2.service.RecruitsService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RecruitsApiController {

    HttpSession session;
    private final RecruitsService recruitsService;

    @GetMapping("/s/recruits/{companysId}/info/companys")
    public CMRespDto<?> findApplyManage(@PathVariable Integer companysId) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getCompanyId() != 0) {
            return new CMRespDto<>(1, "성공",
                    recruitsService.findApplyManage(principal.getCompanyId()));
        } else {
            throw new RuntimeException();
        }
    }

    @GetMapping("/s/recruits/{companysId}/info/recommends")
    public CMRespDto<?> findRecommend(@PathVariable Integer companysId) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        log.debug("디버그 principal : " + principal.getCompanyId());
        if (principal.getCompanyId().equals(companysId)) {
            return new CMRespDto<>(1, "성공", recruitsService.findRecommend());
        } else {
            return new CMRespDto<>(-1, "올바른 접근이 아닙니다", null);
        }
    }

    @GetMapping("/s/recruits/{companysId}/info/positions")
    public CMRespDto<?> findRecommendByPosition(@PathVariable Integer companysId, Integer positionsCodeId) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getCompanyId().equals(companysId)) {
            if (positionsCodeId != null) {
                return new CMRespDto<>(1, "성공", recruitsService.findRecommendByPosition(companysId, positionsCodeId));
            } else {
                return new CMRespDto<>(1, "성공", recruitsService.findRecommend());
            }
        } else {
            return new CMRespDto<>(-1, "올바른 접근이 아닙니다", null);
        }
    }

}
