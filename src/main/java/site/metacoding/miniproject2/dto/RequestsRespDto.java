package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* >>>> 서현 작업함  <<<< */

/* 기존 작업자 : 서현 */
public class RequestsRespDto {

    @NoArgsConstructor
    @Setter
    @Getter
    public static class RequestsInfoRespDto {
        private Integer id;
        private Integer resumeId;
        private Integer wantedId;
        private Integer positionCodeId;
        private String status;
        private Timestamp created;
        private String positionCodeName;
        private Integer careerCodeId;
        private Integer companyId;
        private String companyName;
    }

    @NoArgsConstructor
    @Setter
    @Getter
    public static class RequestsListRespDto {
        private String keyword;
        private Integer id;
        private List<RequestsInfoRespDto> requestsInfoRespDtos;

        public RequestsListRespDto(List<RequestsInfoRespDto> requestsInfoRespDtos) {
            this.requestsInfoRespDtos = requestsInfoRespDtos;
        }

    }
    /* >>>> 서현 작업 종료 <<<< */
}
