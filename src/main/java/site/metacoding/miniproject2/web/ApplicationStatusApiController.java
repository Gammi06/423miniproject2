package site.metacoding.miniproject2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.service.ApplicationStatusService;

@RequiredArgsConstructor
@RestController
public class ApplicationStatusApiController {

    private final ApplicationStatusService applicationStatusService;

    @GetMapping("/applicationstatusall/{id}")
    public CMRespDto<?> findAllList(@PathVariable Integer id, String keyword) {
        return new CMRespDto<>(1, "성공", applicationStatusService.findAllList(id, keyword));
    }

    @GetMapping("/applicationstoatusall/{id}")
    public CMRespDto<?> findWaitingList(@PathVariable Integer id, String keyword) {
        return new CMRespDto<>(1, "성공", applicationStatusService.findWaitingList(id, keyword));
    }

    @GetMapping("/applicationstatusall/{id}")
    public CMRespDto<?> findFinalList(@PathVariable Integer id, String keyword) {
        return new CMRespDto<>(1, "성공", applicationStatusService.findFinalList(id, keyword));
    }
}
