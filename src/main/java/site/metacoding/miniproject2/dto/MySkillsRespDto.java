package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.mySkills.MySkills;

/*기존 작업자 승현 */
public class MySkillsRespDto {

    /* >>>>>>지원 작업함<<<<<<< */
    @Setter
    @Getter
    public static class WantedsSkillsRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer skillsCodeId;
        private String skillsCodeName;

        public MySkills toEntity() {
            return MySkills.builder()
                    .id(id)
                    .userId(id)
                    .resumeId(id)
                    .wantedId(wantedId)
                    .skillsCodeId(skillsCodeId)
                    .build();
        }

    }
    /* >>>>>>>>지원 작업 종료<<<<<<<<<<<< */

    /* 승현 작업 시작 */
    @Getter
    @Setter
    public static class WantedGetSkillRespDto {
        private String skillsCodeName;
    }
    /* 승현 작업 종료 */

    /* 성유 작업 시작 */
    @Getter
    @Setter
    public static class UsersgGetSkillRespDto {
        private String skillsCodeName;
    }
    /* 성유 작업 종료 */
}
