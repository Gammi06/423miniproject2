package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.resumes.Resumes;

/* >>>> 연지 작업함 <<<< */
public class ResumesReqDto {

    @Setter
    @Getter
    public static class ResumeWriteReqDto {
        private String title;
        private String intro;
        private Integer myCareersId;
        private Integer educationsId;
        private Integer skillsCodeId;

        public Resumes toEntity() {
            return Resumes.builder()
                    .title(title)
                    .intro(intro)
                    .build();
        }
    }

}
/* >>>> 연지 작업종료 <<<< */