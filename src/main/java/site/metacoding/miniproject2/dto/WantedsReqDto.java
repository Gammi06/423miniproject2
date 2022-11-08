package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class WantedsReqDto {

    @NoArgsConstructor
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
    }

    @NoArgsConstructor
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

    }

}
