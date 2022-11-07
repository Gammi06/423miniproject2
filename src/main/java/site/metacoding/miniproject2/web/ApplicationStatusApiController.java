package site.metacoding.miniproject2.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.service.ApplicationStatusService;

@RequiredArgsConstructor
@RestController
public class ApplicationStatusApiController {

    private final ApplicationStatusService applicationStatusService;
    private final HttpSession session;

    @GetMapping("/s/allapplicationstatus/{id}")
    public CMRespDto<?> findAllList(@PathVariable Integer id, String keyword) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getId() != id) {
            throw new RuntimeException("권한이 없습니다.");
        }
        return new CMRespDto<>(1, "성공", applicationStatusService.findAllList(id, keyword));
    }

    @GetMapping("/s/waitingapplicationstatus/{id}")
    public CMRespDto<?> findWaitingList(@PathVariable Integer id, String keyword) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getId() != id) {
            throw new RuntimeException("권한이 없습니다.");
        }
        return new CMRespDto<>(1, "성공", applicationStatusService.findWaitingList(id, keyword));
    }

    @GetMapping("/s/finalapplicationstatus/{id}")
    public CMRespDto<?> findFinalList(@PathVariable Integer id, String keyword) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getId() != id) {
            throw new RuntimeException("권한이 없습니다.");
        }
        return new CMRespDto<>(1, "성공", applicationStatusService.findFinalList(id, keyword));
    }
}
