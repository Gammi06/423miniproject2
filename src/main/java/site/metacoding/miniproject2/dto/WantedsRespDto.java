package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* >>>> 수현 작업함  <<<< */

/* 기존 작업자 : 승현 */
public class WantedsRespDto {

    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    public class WantedsListRespDto {
        private Integer totalCount;
        private Integer id;
        private Integer positionCodeId;
        private Integer careerCodeId;
        private String title;
        private String detail;
        private Integer viewCount;
        private Timestamp created;
        private Timestamp enddate;
        private String companyName;
        private String regionCodeName;
        // private List<WantedsSkillsDto> mySkills;
    }
    /*
     * WantedsListRespDto 수정내용
     * photo: api컨트롤러 사용예정 => 삭제
     */

    @Setter
    @Getter
    public class WantedsManageRespDto {
        private Integer id;
        private Integer positionCodeId;
        // private String positionName;
        private Integer careerCodeId;
        // private String careerName;
        private Integer companyId;
        private Integer no;
        private String companyName;
        private String title;
        private String detail;
        private Timestamp enddate;
        private String state; // 모집중/마감
    }

    /*
     * WantedsManageRespDto 수정내용
     * photo: api컨트롤러 사용예정 => 삭제
     * positionName, careerName : Selectbox value에서 CodeId로 Name불러올 수 있다면 삭제
     */

    @Setter
    @Getter
    public class KeywordRespDto {
        private String positionsCodeNames;
        private String regionsCodeNames;
        private String carrerCodeNames;
        // private List<String> skillsCodeNames;
        private Integer page;
        private Integer startNum;
    }
}
