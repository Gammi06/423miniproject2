package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.codes.CareersCodeDao;
import site.metacoding.miniproject2.domain.codes.PositionsCodeDao;
import site.metacoding.miniproject2.domain.codes.RegionsCodeDao;
import site.metacoding.miniproject2.domain.codes.SkillsCodeDao;

/* >>>> 연지 작업함 <<<< */
@RequiredArgsConstructor
@Service
public class CodesService {

    private final CareersCodeDao careersCodeDao;
    private final PositionsCodeDao positionsCodeDao;
    private final RegionsCodeDao regionsCodeDao;
    private final SkillsCodeDao skillsCodeDao;

    public void careersCodeFindAll() {
        careersCodeDao.findAll();
    }

    public void careersCodeFindById(Integer id) {
        careersCodeDao.findById(id);
    }

    public void positionsCodeFindAll() {
        positionsCodeDao.findAll();
    }

    public void positionsCodeFindById(Integer id) {
        positionsCodeDao.findById(id);
    }

    public void regionsCodeFindAll() {
        regionsCodeDao.findAll();
    }

    public void regionsCodeFindById(Integer id) {
        regionsCodeDao.findById(id);
    }

    public void skillsCodeFindAll() {
        skillsCodeDao.findAll();
    }

    public void skillsCodeFindById(Integer id) {
        skillsCodeDao.findById(id);
    }

}
/* >>>> 연지 작업함 <<<< */