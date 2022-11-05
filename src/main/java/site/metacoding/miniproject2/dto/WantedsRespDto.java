package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.MySkillsRespDto.WantedGetSkillRespDto;

public class WantedsRespDto {

    // ////////////////// 승현 사용 Dto /////////////////////
    @Setter
    @Getter
    public static class SearchDto {
        private Integer sortType;
        private Integer regionCodeId;
        private Integer careerCodeId;
        private List<Integer> skillCode;
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
        private String status; // 모집중/마감
    }

    @Setter
    @Getter
    public static class WantedDetailRespDto {
        private Integer id;
        private String status; // 모집중/마감
        private String positionCodeName;
        private String careerCodeName;
        private String title;
        private String detail;
        private Integer viewCount;
        private String companyName;
        private String regionCodeName;
        private List<WantedGetSkillRespDto> mySkills;
        private Integer likeCount;
        // private LikeDto mylikes;
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

    /* 지원 작업!! */
    @Setter
    @Getter
    public static class WantedLisLikestRespDto {// likes
        private Integer companyId;
        private Integer userId;
        private String title;
        private String detail;
        private String companyName;
        private Timestamp created;
        private Timestamp enddate;
        private String status;
    }
}
