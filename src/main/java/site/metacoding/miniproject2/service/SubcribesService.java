package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.subcribes.SubcribesDao;

@RequiredArgsConstructor
@Service
public class SubcribesService {
    private final SubcribesDao subcribesDao;

    public void subcribesListPage(Integer id) {
        subcribesDao.subcribesListPage(id);
    }

}
