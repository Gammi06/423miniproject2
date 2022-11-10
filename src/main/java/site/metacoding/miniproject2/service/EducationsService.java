package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.educations.EducationsDao;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class EducationsService {
    private final EducationsDao educationsDao;

    /* >>>> 연지 작업함 <<<< */

    @Transactional
    public void insert() {
        educationsDao.insert();
    }

    public void findAll() {
        educationsDao.findAll();
    }

    public void findById(Integer id) {
        educationsDao.findById(id);
    }

    @Transactional
    public void updateById(Integer id) {
        educationsDao.updateById(id);
    }

    @Transactional
    public void deleteById(Integer id) {
        educationsDao.deleteById(id);
    }

}
/* >>>> 연지 작업종료 <<<< */