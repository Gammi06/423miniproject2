package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;

public class ApplyRespDto {

    /* >>>> 승현 작업함 <<<< */
    @Getter
    @Setter
    public static class ApplyFindByIdRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer resumeId;
        private String status;
        private Timestamp created;
    }

    @Getter
    @Setter
    public static class ApplyInsertRespDto {
        private Integer wantedId;
        private Integer resumeId;

        public ApplyInsertRespDto(ApplyUserReqDto applyUserReqDto) {
            this.wantedId = applyUserReqDto.getWantedId();
            this.resumeId = applyUserReqDto.getWantedId();
        }
    }

    /* >>>> <<<< */
}
