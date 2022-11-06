package site.metacoding.miniproject2.domain.resumes;

import java.util.List;

import site.metacoding.miniproject2.dto.ResumesReqDto.ResumeUpdateReqDto;
import site.metacoding.miniproject2.dto.ResumesReqDto.ResumeWriteReqDto;
import site.metacoding.miniproject2.dto.ResumesRespDto.ResumeDetailRespDto;
import site.metacoding.miniproject2.dto.ResumesRespDto.ResumeListRespDto;

/* >>>> 연지 작업함 <<<< */
public interface ResumesDao {

    public ResumeDetailRespDto findById(Integer id);

    public ResumeWriteReqDto insert(ResumeWriteReqDto resumeWriteReqDto);

    public ResumeListRespDto findByUserId(Integer userId);

    public List<ResumeListRespDto> findAllByUserId(Integer userId);

    public void updateById(ResumeUpdateReqDto resumeUpdateReqDto);

    public void deleteById(Integer id);

}
/* >>>> 연지 작업종료 <<<< */