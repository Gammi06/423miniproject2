package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.MySkillsRespDto.WantedsSkillsRespDto;

public class WantedsRespDto {

    // ////////////////// 승현 사용 Dto /////////////////////
    @Setter
    @Getter
    public static class SearchDto {
        private Integer sortType;
        private String positionCodeName;
        private String regionCodeName;
        private String careerCodeName;
        private List<String> skillCodeName;

        @Builder
        public SearchDto(Integer sortType, String positionCodeName, String regionCodeName, String careerCodeName,
                List<String> skillCodeName) {
            this.sortType = sortType;
            this.positionCodeName = positionCodeName;
            this.regionCodeName = regionCodeName;
            this.careerCodeName = careerCodeName;
            this.skillCodeName = skillCodeName;
        }
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class MyLikeWantedRespDto {
        private Integer wantedId;
        private Integer userId;
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

    // ////////////////// 수현 사용 Dto /////////////////////
    @Setter
    @Getter
    public static class WantedsRecruitsManageRespDto {
        private Integer id;
        private Integer companyId;
        private Integer positionCodeId;
        private String positionName;
        private Integer careerCodeId;
        private String careerName;
        private String title;
        private String detail;
        private String state; // 모집중/마감
    }

    @Setter
    @Getter
    public static class WantedsRecruitsManageCareersRespDto {
        private Integer id;
        private Integer companyId;
        private Integer careerCodeId;
        private String careerName;
        private String title;
        private String detail;
        private String state;
    }

    @Setter
    @Getter
    public static class WantedsRecruitsManagePositionsRespDto {
        private Integer id;
        private Integer companyId;
        private Integer positionCodeId;
        private String positionName;
        private String title;
        private String detail;
        private String state;
    }

}
