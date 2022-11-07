package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.EducationsRespDto.EducationsResumeRespDto;
import site.metacoding.miniproject2.dto.MyCareersRespDto.MyCareersResumeRespDto;
import site.metacoding.miniproject2.dto.MySkillsRespDto.MySkillsResumeRespDto;

/* >>>> 연지 작업함 <<<< */
public class ResumesRespDto {

    @Setter
    @Getter
    public static class ResumeListRespDto {
        private Integer id;
        private String title;
        private Timestamp created;
    }

    /* 연지 작업시작 */
    @Getter
    @Setter
    public static class ResumeDetailRespDto {
        private Integer id;
        private String title;
        private String userName;
        private String email;
        private String phoneNumber;
        private String intro;
        private List<MyCareersResumeRespDto> myCareers;
        private List<EducationsResumeRespDto> myEducations;
        private List<MySkillsResumeRespDto> mySkills;
    }
    /* 연지 작업끝 */
}
/* >>>> 연지 작업종료 <<<< */