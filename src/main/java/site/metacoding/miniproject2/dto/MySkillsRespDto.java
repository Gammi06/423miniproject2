package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/*기존 작업자 승현 */
public class MySkillsRespDto {

    /* 연지 작업시작 */
    @Getter
    @Setter
    public static class MySkillsResumeRespDto { // 이력서 작성 내 스킬
        private Integer userId;
        private Integer skillsCodeId;
        private String skillsCodeName;
    }
    /* 연지 작업끝 */

    /* >>>>>>>>지원 작업 시작<<<<<<<<<<<< */
    @Setter
    @Getter
    public static class WantedsSkillsRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer skillsCodeId;
        private String skillsCodeName;
    }
    /* >>>>>>>>지원 작업 종료<<<<<<<<<<<< */

    /* 승현 작업 시작 */
    @Getter
    @Setter
    public static class WantedGetSkillRespDto {
        private String skillsCodeName;
    }
    /* 승현 작업 종료 */
}
