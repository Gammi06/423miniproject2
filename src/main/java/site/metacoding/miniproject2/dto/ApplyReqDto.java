package site.metacoding.miniproject2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ApplyReqDto {

    /* >>>> 승현 작업함 <<<< */
    @Getter
    @Setter
    public static class ApplyUserReqDto {
        private Integer wantedId;
        private Integer resumeId;

        @Builder
        public ApplyUserReqDto(Integer wantedId, Integer resumeId) {
            this.wantedId = wantedId;
            this.resumeId = resumeId;
        }
    }

    @Getter
    @Setter
    public static class ApplyFindReqDto {
        private Integer userId;
        private Integer wantedId;

        @Builder
        public ApplyFindReqDto(Integer userId, Integer wantedId) {
            this.userId = userId;
            this.wantedId = wantedId;
        }
    }

    /* >>>> <<<< */
}
