package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/* >>>> 연지 작업함 <<<< */
public class EducationsRespDto {

    @Setter
    @Getter
    // Dto이름 EducationsListRespDto -> EducationsResumeRespDto로 수정함 : 연지
    public static class EducationsResumeRespDto { // 이력서 작성 내 학력
        private Timestamp startDate;
        private Timestamp endDate;
        private String instruction;
        private String state;
    }

}
/* >>>> 연지 작업종료 <<<< */
