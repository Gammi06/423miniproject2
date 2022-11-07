package site.metacoding.miniproject2.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.EducationsReqDto.EducationsResumeReqDto;
import site.metacoding.miniproject2.dto.MyCareersReqDto.MyCareersResumeReqDto;
import site.metacoding.miniproject2.dto.MySkillsReqDto.MySkillsResumeReqDto;

/* >>>> 연지 작업함 <<<< */
public class ResumesReqDto {

    @Setter
    @Getter
    public static class ResumeWriteReqDto {
        private Integer userId; // 추가됨 : 연지
        private Integer positionsCodeId; // 추가됨 : 연지
        private String title;
        private String intro;
        private List<MyCareersResumeReqDto> myCareers;
        private List<EducationsResumeReqDto> myEducations;
        private List<MySkillsResumeReqDto> mySkills;
    }

    @Setter
    @Getter
    public static class ResumeUpdateReqDto {
        private Integer id;
        private String title;
        private String intro;
        private List<MyCareersResumeReqDto> myCareers;
        private List<EducationsResumeReqDto> myEducations;
        private List<MySkillsResumeReqDto> mySkills;
    }

}
/* >>>> 연지 작업종료 <<<< */