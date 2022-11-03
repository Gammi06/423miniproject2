package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.resumes.Resumes;
import site.metacoding.miniproject2.domain.resumes.ResumesDao;

/* >>>> 연지 작업함 <<<< */
@RequiredArgsConstructor
@Service
public class ResumesService {

    private final ResumesDao resumesDao;

    public void insert() {
        resumesDao.insert();
    }

    public void findAll() {
        resumesDao.findAll();
    }

    public void findById(Integer id) {
        resumesDao.findById(id);
    }

    public void updateById(Integer id, Resumes resumes) {
        resumesDao.updateById(id, resumes);
    }

    public void deleteById(Integer id) {
        resumesDao.deleteById(id);
    }

}
/* >>>> 연지 작업함 <<<< */