package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.applys.ApplysDao;

@RequiredArgsConstructor
@Service
public class ApplyService {

    private final ApplysDao applysDao;

    public void findById() {
        applysDao.findById(null);
    }

    public void insert() {
        applysDao.insert();

    }

    public void deleteById() {
        applysDao.deleteById();
    }
}
