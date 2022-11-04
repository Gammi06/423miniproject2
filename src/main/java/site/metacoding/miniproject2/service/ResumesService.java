package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.resumes.Resumes;
import site.metacoding.miniproject2.domain.resumes.ResumesDao;
import site.metacoding.miniproject2.dto.ResumesReqDto.ResumeUpdateReqDto;
import site.metacoding.miniproject2.dto.ResumesRespDto.ResumeListRespDto;

/* >>>> 연지 작업함 <<<< */
@RequiredArgsConstructor
@Service
public class ResumesService {

    private final ResumesDao resumesDao;

    public void insert(Resumes resumes) {
        resumesDao.insert(resumes);
    }

    public void findAll() {
        resumesDao.findAll();
    }

    public List<ResumeListRespDto> findById(Integer id) {
        resumesDao.findById(id);
        return null;
    }

    public ResumeUpdateReqDto updateById(Integer id, Resumes resumes) {
        resumesDao.updateById(id, resumes);
        return null;
    }

    public void deleteById(Integer id) {
        resumesDao.deleteById(id);
    }

}
/* >>>> 연지 작업종료 <<<< */