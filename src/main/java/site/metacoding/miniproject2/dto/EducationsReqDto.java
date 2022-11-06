package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/* >>>> 연지 작업함 <<<< */
public class EducationsReqDto {

    @Setter
    @Getter
    public static class EducationsResumeReqDto {
        private Timestamp startDate;
        private Timestamp endDate;
        private String instruction;
        private String state;
    }

}
/* >>>> 연지 작업종료 <<<< */