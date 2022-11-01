package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class ApplyRespDto {

    /* >>>> 승현 작업함 <<<< */
    @Getter
    @Setter
    public static class ApplyListRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer resumeId;
        private Integer status;
        private Timestamp created;
    }
    /* >>>> <<<< */
}
