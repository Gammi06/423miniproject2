package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.applys.Applys;

public class ApplyReqDto {

    /* >>>> 승현 작업함 <<<< */
    @Getter
    @Setter
    public static class ApplyUserReqDto {
        private Integer wantedId;
        private Integer resumeId;

        public Applys toEntity() {
            return Applys.builder()
                    .wantedId(wantedId)
                    .resumeId(resumeId)
                    .build();
        }
    }

    /* >>>> <<<< */
}
