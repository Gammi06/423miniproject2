package site.metacoding.miniproject2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.service.RequestsService;

@RequiredArgsConstructor
@RestController
public class RequestsApiController {

    private final RequestsService requestsService;

    @GetMapping("/s/proposal/{id}")
    public CMRespDto<?> findRequests(@PathVariable Integer id, String keyword) {
        return new CMRespDto<>(1, "성공", requestsService.findRequests(id, keyword));
    }
}
