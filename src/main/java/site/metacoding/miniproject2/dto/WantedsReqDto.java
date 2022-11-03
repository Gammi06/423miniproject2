package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

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
    }

}
