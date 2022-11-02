package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.applicationStatus.ApplicationStatusDao;

@RequiredArgsConstructor
@Service
public class ApplicationStatusService {

    private final ApplicationStatusDao applicationStatusDao;

    public void findAll() {
        applicationStatusDao.findAll();
    }

    public void findCounts() {
        applicationStatusDao.findCounts();

    }

    public void findWaiting() {
        applicationStatusDao.findWaiting();
    }

    public void findFinal() {
        applicationStatusDao.findFinal();
    }
}
