package site.metacoding.miniproject2.domain.educations;

import java.util.List;

import site.metacoding.miniproject2.dto.EducationsRespDto.EducationsResumeRespDto;

/* >>>> 연지 작업함 <<<< */
public interface EducationsDao {

    public void insert();

    public void findAll();

    public void findById(Integer id);

    public void updateById(Integer id);

    public void deleteById(Integer id);

    /* 연지 작업 시작함 */
    public List<EducationsResumeRespDto> findAllByResumeId(Integer resumeId);

    public void insertByResumeId();
    /* 연지 작업 종료 */
}
/* >>>> 연지 작업종료 <<<< */