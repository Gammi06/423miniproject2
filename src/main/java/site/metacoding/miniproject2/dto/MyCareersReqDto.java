package site.metacoding.miniproject2.dto;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class MyCareersReqDto {
    /* >>>> 성유 작업함 <<<< */
    @Getter
    @Setter
    public static class MyCareersResumReqDto { // 이력서 작성 내 학력
        private Integer resumeId;
        private Integer status;
        private Timestamp created;
    }

    @Getter
    @Setter
    public static class MyCareersEditReqDto { // 계정 설정-프로필 수정 내 학력
        private Integer id;
        private Integer status;
        private Timestamp created;
    }
    /* >>>> 성유 작업함 <<<< */

}
