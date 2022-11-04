package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* >>>> 서현 작업함  <<<< */

/* 기존 작업자 : 서현 */
public class ApplicationStatusRespDto {

    @Setter
    @Getter
    public static class ApplicationStatusAllCountRespDto {
        private Integer id;
        private Integer statusAll;
        private Integer statusC;
        private Integer statusFinal;
    }

    @Setter
    @Getter
    public static class ApplicationStatusAllInfoRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer resumeId;
        private Integer state;
        private Integer positionCodeId;
        private Timestamp created;
        private String positionCodeName;
        private Integer companyId;
        private String companyName;
        private Integer userId;
    }

    @NoArgsConstructor
    @Setter
    @Getter
    public static class ApplicationStatusAllListRespDto {
        private String keyword;
        private Integer id;
        private List<ApplicationStatusAllCountRespDto> applicationStatusAllCountRespDtos;
        private List<ApplicationStatusAllInfoRespDto> applicationStatusAllInfoRespDtos;

        public ApplicationStatusAllListRespDto(List<ApplicationStatusAllCountRespDto> applicationStatusAllCountRespDtos,
                List<ApplicationStatusAllInfoRespDto> applicationStatusAllInfoRespDtos) {
            this.applicationStatusAllCountRespDtos = applicationStatusAllCountRespDtos;
            this.applicationStatusAllInfoRespDtos = applicationStatusAllInfoRespDtos;
        }
    }

    @Setter
    @Getter
    public static class ApplicationStatusWaitingCountRespDto {
        private Integer id;
        private Integer statusAll;
        private Integer statusC;
        private Integer statusFinal;
    }

    @Setter
    @Getter
    public static class ApplicationStatusWaitingInfoRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer resumeId;
        private Integer state;
        private Integer positionCodeId;
        private Timestamp created;
        private String positionCodeName;
        private Integer companyId;
        private String companyName;
        private Integer userId;
    }

    @NoArgsConstructor
    @Setter
    @Getter
    public static class ApplicationStatusWaitingListRespDto {
        private String keyword;
        private Integer id;
        private List<ApplicationStatusWaitingCountRespDto> applicationStatusWaitingCountRespDtos;
        private List<ApplicationStatusWaitingInfoRespDto> applicationStatusWaitingInfoRespDtos;

        public ApplicationStatusWaitingListRespDto(
                List<ApplicationStatusWaitingCountRespDto> applicationStatusWaitingCountRespDtos,
                List<ApplicationStatusWaitingInfoRespDto> applicationStatusWaitingInfoRespDtos) {
            this.applicationStatusWaitingCountRespDtos = applicationStatusWaitingCountRespDtos;
            this.applicationStatusWaitingInfoRespDtos = applicationStatusWaitingInfoRespDtos;
        }
    }

    @Setter
    @Getter
    public static class ApplicationStatusFinalCountRespDto {
        private Integer id;
        private Integer statusAll;
        private Integer statusC;
        private Integer statusFinal;
    }

    @Setter
    @Getter
    public static class ApplicationStatusFinalInfoRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer resumeId;
        private Integer state;
        private Integer positionCodeId;
        private Timestamp created;
        private String positionCodeName;
        private Integer companyId;
        private String companyName;
        private Integer userId;
    }

    @NoArgsConstructor
    @Setter
    @Getter
    public static class ApplicationStatusFinalListRespDto {
        private String keyword;
        private Integer id;
        private List<ApplicationStatusFinalCountRespDto> applicationStatusFinalCountRespDtos;
        private List<ApplicationStatusFinalInfoRespDto> applicationStatusFinalInfoRespDtos;

        public ApplicationStatusFinalListRespDto(
                List<ApplicationStatusFinalCountRespDto> applicationStatusFinalCountRespDtos,
                List<ApplicationStatusFinalInfoRespDto> applicationStatusFinalInfoRespDtos) {
            this.applicationStatusFinalCountRespDtos = applicationStatusFinalCountRespDtos;
            this.applicationStatusFinalInfoRespDtos = applicationStatusFinalInfoRespDtos;
        }
    }

    /* >>>> 서현 작업 종료 <<<< */
}
