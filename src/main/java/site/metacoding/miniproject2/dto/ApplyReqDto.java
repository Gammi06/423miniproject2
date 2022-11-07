package site.metacoding.miniproject2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ApplyReqDto {

    /* >>>> 승현 작업함 <<<< */
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ApplyUserReqDto {
        private Integer userId;
        private Integer wantedId;
        private Integer resumeId;
    }

    @Getter
    @Setter
    public static class ApplyFindReqDto {
        private Integer userId;
        private Integer wantedId;

        public ApplyFindReqDto(ApplyUserReqDto applyUserReqDto) {
            this.userId = applyUserReqDto.getUserId();
            this.wantedId = applyUserReqDto.getWantedId();
        }

    }

    /* >>>> <<<< */
}
