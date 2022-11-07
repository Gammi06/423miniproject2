package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.myCareers.MyCareers;

public class MyCareersReqDto {
    /* >>>> 성유 작업함 <<<< */
    @Getter
    @Setter
    public static class MyCareersResumeReqDto { // 이력서 작성 내 경력

        private Integer userId; // userId 추가됨 : 연지
        private Integer resumeId; // resumeId 추가됨 : 연지
        private Timestamp startdate;
        private Timestamp enddate;
        private String companyName;

        public MyCareers toEntity() {
            return MyCareers.builder()
                    .userId(userId)
                    .startdate(null)
                    .enddate(null)
                    .companyName(companyName)
                    .build();
        }

    }
    /* >>>> 성유 작업함 <<<< */

}
