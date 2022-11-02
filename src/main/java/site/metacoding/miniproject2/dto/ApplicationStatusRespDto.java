package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/* >>>> 서현 작업함  <<<< */

/* 기존 작업자 : 서현 */
public class ApplicationStatusRespDto {

    @Setter
    @Getter
    public static class ApplicationStatusInfoRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer resumeId;
        private Integer state;
        private Timestamp created;
    }

    /* >>>> 서현 작업 종료 <<<< */
}
