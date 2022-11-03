package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.wanteds.Wanteds;

/* >>>> 수현 작업함  <<<< */

/* 기존 작업자 : 수현 */
public class WantedsReqDto {

    @Setter
    @Getter
    public static class WantedsSaveReqDto {
        private String wantedTitle;
        private String wantedDetail;
        private Integer positionCodeId;
        private Integer careerCodeId;
        private String pay;
        private Timestamp endDate;

        public Wanteds toEntity() {
            return Wanteds.builder()
                    .title(wantedTitle)
                    .detail(wantedDetail)
                    .positionCodeId(positionCodeId)
                    .careerCodeId(careerCodeId)
                    .pay(pay)
                    .enddate(endDate)
                    .build();
        }
    }

    @Setter
    @Getter
    public static class WantedsUpdateReqDto {
        private String wantedTitle;
        private String wantedDetail;
        private Integer positionCodeId;
        private Integer careerCodeId;
        private String pay;
        private Timestamp endDate;

        public Wanteds toEntity() {
            return Wanteds.builder()
                    .title(wantedTitle)
                    .detail(wantedDetail)
                    .positionCodeId(positionCodeId)
                    .careerCodeId(careerCodeId)
                    .pay(pay)
                    .enddate(endDate)
                    .build();
        }
    }

}

/* >>>> 수현 작업 종료 <<<< */
