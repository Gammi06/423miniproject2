package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.codes.CareersCodeDao;
import site.metacoding.miniproject2.domain.codes.PositionsCodeDao;
import site.metacoding.miniproject2.domain.codes.RegionsCodeDao;
import site.metacoding.miniproject2.domain.codes.SkillsCodeDao;
import site.metacoding.miniproject2.dto.CodesRespDto.CareersCodeRespDto;
import site.metacoding.miniproject2.dto.CodesRespDto.PositionsCodeRespDto;
import site.metacoding.miniproject2.dto.CodesRespDto.RegionsCodeRespDto;
import site.metacoding.miniproject2.dto.CodesRespDto.SkillsCodeRespDto;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CodesService {

    /* >>>> 연지 작업함 <<<< */
    private final CareersCodeDao careersCodeDao;
    private final PositionsCodeDao positionsCodeDao;
    private final RegionsCodeDao regionsCodeDao;
    private final SkillsCodeDao skillsCodeDao;

    public List<CareersCodeRespDto> careersCodeFindAll() {
        return careersCodeDao.findAll();
    }

    public CareersCodeRespDto careersCodeFindById(Integer id) {
        return careersCodeDao.findById(id);
    }

    public List<PositionsCodeRespDto> positionsCodeFindAll() {
        return positionsCodeDao.findAll();
    }

    public PositionsCodeRespDto positionsCodeFindById(Integer id) {
        return positionsCodeDao.findById(id);
    }

    public List<RegionsCodeRespDto> regionsCodeFindAll() {
        return regionsCodeDao.findAll();
    }

    public RegionsCodeRespDto regionsCodeFindById(Integer id) {
        return regionsCodeDao.findById(id);
    }

    public List<SkillsCodeRespDto> skillsCodeFindAll() {
        return skillsCodeDao.findAll();
    }

    public SkillsCodeRespDto skillsCodeFindById(Integer id) {
        return skillsCodeDao.findById(id);
    }
    /* >>>> 연지 작업함 <<<< */
}