package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;

/*>>>>>>지원 작업함<<<<<<< */
/*기존 작업자 승현 */
public class MySkillsReqDto {
    @Setter
    @Getter
    public static class WantedsSkillsRespDto {
        private Integer id;
        private Integer wantedId;
        private Integer skillsCodeId;
        private String skillsCodeName;
    }

}
