package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;

/* >>>>> 연지 작업함 <<<<< */
public class MySkillsReqDto {

    /* 연지 작업시작 */
    @Getter
    @Setter
    public static class MySkillsResumeReqDto { // 이력서 작성 내 스킬
        private Integer userId;
        private Integer skillsCodeId;
        private String skillsCodeName;
    }
    /* 연지 작업종료 */

}
/* >>>>> 연지 작업끝 <<<<< */
