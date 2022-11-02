package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.requests.RequestsDao;

@RequiredArgsConstructor
@Service
public class RequestsService {

    private final RequestsDao requestsDao;

    public void findRequest() {
        requestsDao.findRequest();
    }
}
