package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;

/* >>>> 연지 작업함 <<<< */
public class ResumesReqDto {

    @Setter
    @Getter
    public class ResumeWriteReqDto {
        private String title;
        private String intro;
        private Integer myCareersId;
        private Integer educationsId;
        private Integer skillsCodeId;
    }

}
/* >>>> 연지 작업종료 <<<< */