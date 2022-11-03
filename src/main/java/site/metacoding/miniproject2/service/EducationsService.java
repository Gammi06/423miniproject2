package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.educations.EducationsDao;

/* >>>> 연지 작업함 <<<< */
@RequiredArgsConstructor
@Service
public class EducationsService {

    private final EducationsDao educationsDao;

    public void insert() {
        educationsDao.insert();
    }

    public void findAll() {
        educationsDao.findAll();
    }

    public void findById(Integer id) {
        educationsDao.findById(id);
    }

    public void updateById(Integer id) {
        educationsDao.updateById(id);
    }

    public void deleteById(Integer id) {
        educationsDao.deleteById(id);
    }

}
/* >>>> 연지 작업함 <<<< */