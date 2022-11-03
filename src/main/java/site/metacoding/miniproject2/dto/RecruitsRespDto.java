package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/* >>>> 수현 작업함  <<<< */

/* 기존 작업자 : 수현 */
public class RecruitsRespDto {

    @Setter
    @Getter
    public static class RecruitsApplyManageRespDto {
        private Integer id;
        private Integer companysId;
        private String wantedTitle;
        private Timestamp endDate;
        private String state;
    }

    @Setter
    @Getter
    public static class RecruitsRecommendRespDto {
        private Integer id;
        private Integer companysId;
        private String resumeTitle;
        private String userName;
        private Timestamp date;
        private String positionName;
        private Integer positionsCodeId;
    }

}

/* >>>> 수현 작업 종료 <<<< */