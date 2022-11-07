package site.metacoding.miniproject2.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.service.RequestsService;

@RequiredArgsConstructor
@RestController
public class RequestsApiController {

    private final RequestsService requestsService;
    private final HttpSession session;

    @GetMapping("/s/proposal/{id}")
    public CMRespDto<?> findRequests(@PathVariable Integer id, String keyword) {
        SessionUsers jwtUsers = (SessionUsers) session.getAttribute("jwtUsers");
        if (jwtUsers.getId() != id) {
            throw new RuntimeException("권한이 없습니다.");
        }
        return new CMRespDto<>(1, "성공", requestsService.findRequests(id, keyword));
    }
}
