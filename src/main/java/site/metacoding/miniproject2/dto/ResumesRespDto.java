package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

/* >>>> 연지 작업함 <<<< */
public class ResumesRespDto {

    @Setter
    @Getter
    public static class ResumeListRespDto {
        private Integer id;
        private String title;
        private Timestamp created;
    }

}
/* >>>> 연지 작업종료 <<<< */