package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.requests.RequestsDao;
import site.metacoding.miniproject2.dto.RequestsRespDto.RequestsInfoRespDto;
import site.metacoding.miniproject2.dto.RequestsRespDto.RequestsListRespDto;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RequestsService {

    private final RequestsDao requestsDao;

    public RequestsListRespDto findRequests(Integer id, String keyword) {
        List<RequestsInfoRespDto> requestsInfoRespDtos = requestsDao.findRequests(id, keyword);
        RequestsListRespDto requestsListRespDto = new RequestsListRespDto(requestsInfoRespDtos);
        requestsListRespDto.setId(id);
        requestsListRespDto.setKeyword(keyword);
        return requestsListRespDto;
    }
}
