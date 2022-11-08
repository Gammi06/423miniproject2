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
        private String wantedTitle;
        private Timestamp created;
        private String state;

    }

    @Setter
    @Getter
    public static class RecruitsRecommendByPositionRespDto {
        private Integer id;
        private String resumeTitle;
        private String userName;
        private Timestamp date;
        private String positionName;
        private Integer positionsCodeId;

        // public RecruitsRecommendByPositionRespDto(SessionUsers sessionUsers) {
        // this.companysId = sessionUsers.getCompanyId();
        // }
    }

    @Setter
    @Getter
    public static class RecruitsRecommendRespDto {
        private Integer id;
        private String positionName;
        private String resumeTitle;
        private String userName;
        private Timestamp date;
    }

}

/* >>>> 수현 작업 종료 <<<< */