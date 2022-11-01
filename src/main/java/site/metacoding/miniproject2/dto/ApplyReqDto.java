package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.applys.Applys;

public class ApplyReqDto {

    @Getter
    @Setter
    public class ApplyUserReqDto {
        private Integer wantedId;
        private Integer resumeId;

        public Applys ToEntity() {
            return Applys.builder()
                    .wantedId(wantedId)
                    .resumeId(resumeId)
                    .build();
        }
    }
}
