package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class ApplyRespDto {

    @Getter
    @Setter
    public class ApplyListRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer resumeId;
        private Integer status;
        private Timestamp created;
    }
}
