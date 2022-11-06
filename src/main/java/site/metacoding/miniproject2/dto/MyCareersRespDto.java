package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class MyCareersRespDto {

    /* >>>> 성유 작업함 <<<< */
    @Getter
    @Setter
    public static class MyCareersResumeRespDto { // 이력서 작성 내 경력
        private Integer userId;
        private Timestamp startdate;
        private Timestamp enddate;
        private String companyName;
    }

    @Getter
    @Setter
    public static class MyCareersEditRespDto { // 계정 설정-프로필 수정 내 경력
        private Integer id;
        private Integer userId;
    }
}
