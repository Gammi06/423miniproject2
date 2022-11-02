package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.MySkillsRespDto.WantedsSkillsRespDto;

public class WantedsRespDto {
    /*
     * 작업자: 수현
     * AllWantedsListDto, PagingDto, PagingWantedsListDto, WantedDetailAndCompanyDto
     * 삭제
     */

    /* 작업자 승현: Dto 내부 수정함 */

    @Setter
    @Getter
    public static class SearchDto {
        private Integer sortType;
        private String positionCodeName;
        private String regionCodeName;
        private String careerCodeName;
        private List<String> skillCodeName;
    }

    @Setter
    @Getter
    public static class WantedListRespDto {
        private Integer id;
        private String positionCodeName;
        private String careerCodeName;
        private String title;
        private String companyName;
        private String regionCodeName;
        private String state; // 모집중/마감
    }

    @Setter
    @Getter
    public static class WantedDetailRespDto {
        private Integer id;
        private String state; // 모집중/마감
        private String positionCodeName;
        private String careerCodeName;
        private String title;
        private String detail;
        private Integer viewCount;
        private String companyName;
        private String regionCodeName;
        private List<WantedsSkillsRespDto> mySkills;
        private Integer likeCount;
        private LikeDto mylikes;
        private Timestamp created;
        private Timestamp enddate;

        @Getter
        @Setter
        public static class LikeDto {
            private boolean isLiked;
        }

    }

    /* //////////////////// */

    @Setter
    @Getter
    public static class WantedsManageRespDto {
        private Integer id;
        private Integer positionCodeId;
        private String positionName;
        private Integer careerCodeId;
        private String careerName;
        private Integer companyId;
        private Integer no;
        private String companyName;
        private String title;
        private String detail;
        private Timestamp enddate;
        private String state; // 모집중/마감
    }

    /* 작업자 승현: KeywordRespDto 삭제함 : view를 위한 값이라 판단하여 삭제함 */
}
