package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.wanteds.Wanteds;

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
        private Integer companysId;

        public Wanteds toEntity(){
            return Wanteds.builder()
            .title(wantedTitle)
            .detail(wantedDetail)
            .positionCodeId(positionCodeId)
            .careerCodeId(careerCodeId)
            .pay(pay)
            .enddate(endDate)
            .companyId(companysId)
            .build();
        }
        
    }

    @Setter
    @Getter
    public static class WantedsUpdateReqDto {
        private Integer id;
        private String wantedTitle;
        private String wantedDetail;
        private Integer positionCodeId;
        private Integer careerCodeId;
        private String pay;
        private Timestamp endDate;
        private Integer companysId;

        public Wanteds toEntity(){
            return Wanteds.builder()
            .id(id)
            .title(wantedTitle)
            .detail(wantedDetail)
            .positionCodeId(positionCodeId)
            .careerCodeId(careerCodeId)
            .pay(pay)
            .enddate(endDate)
            .companyId(companysId)
            .build();
        }
    }

}
