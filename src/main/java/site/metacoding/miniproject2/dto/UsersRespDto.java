package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.miniproject2.dto.CodesRespDto.CareersCodeRespDto;
import site.metacoding.miniproject2.dto.CodesRespDto.PositionsCodeRespDto;
import site.metacoding.miniproject2.dto.CodesRespDto.SkillsCodeRespDto;
import site.metacoding.miniproject2.dto.EducationsRespDto.EducationsListRespDto;
import site.metacoding.miniproject2.dto.MyCareersRespDto.MyCareersEditRespDto;

public class UsersRespDto {

    /* >>>>> 성유 작업함 <<<<< */

    @Getter
    @Setter
    public static class AuthRespDto {
        private Integer id;
        private String userId;
        private String userPassword; // 비밀번호 숨기기
        private String role;
        private Integer companyId;
    }

    @Getter
    @Setter
    public static class SessionCompanyRespDto {
        private Integer id;
        private Integer companyId;
    }

    @Getter
    @Setter
    public static class UsersInfoRespDto {
        private Integer id;
        private String userId;
        private String userPassword;
        private String userName;
        private Integer age;
        private String phoneNumber;
        private String email;
        private String photo;
        private Integer positionCodeId;
        private Integer mycareerId;
        private Timestamp created;
        private String role;

    }

    @Getter
    @Setter
    public static class JoinRespDto {
        private Integer id;
        private String userId;
        private String userPassword;
        private String userName;
        private Integer age;
        private String phoneNumber;
        private String email;
    }

    @Getter
    @Setter
    public static class EditRespDto { // 기본정보 수정
        private Integer id;
        private String userName;
        private String email;
        private String phoneNumber;

        public EditRespDto(UsersInfoRespDto infoRespDto) {
            this.id = infoRespDto.getId();
            this.userName = infoRespDto.getUserName();
            this.email = infoRespDto.getEmail();
            this.phoneNumber = infoRespDto.getPhoneNumber();
        }

    }

    @Getter
    @Setter
    public static class PasswordEditRespDto {
        private Integer id;
        private String userPassword;

        public PasswordEditRespDto(UsersInfoRespDto infoRespDto) {
            this.id = infoRespDto.getId();
            this.userPassword = infoRespDto.getUserPassword();
        }

    }

    @Getter
    @Setter
    public static class ProfileEditAllRespDto {
        private List<PositionsCodeRespDto> positionCodes; // 포지션
        private List<CareersCodeRespDto> careersCodeRes; // 경력
        private List<SkillsCodeRespDto> skillsCo; // 스킬
        private List<MyCareersEditRespDto> myCareers; // 경력2
        private List<EducationsListRespDto> educations; // 학력
    }

    /* >>>>> 성유 작업 종료<<<<< */

    /* >>>>> 서현 작업함 <<<<< */
    @Setter
    @Getter
    public static class InfoRespDto {
        private Integer id;
        private String userName;
        private String phoneNumber;
        private String email;
        private Integer positionCodeId;
        private String positionCodeName;
    }

    @Setter
    @Getter
    public static class InfoCountRespDto {
        private Integer id;
        private Integer statusAll;
        private Integer likesCount;
        private Integer subscribesCount;
        private Integer requestsCount;
    }

    @Setter
    @Getter
    public static class RecommendByPositionRespDto {
        private Integer id;
        private Integer no;
        private String companyName;
        private String title;
        private String detail;
    }

    @Setter
    @Getter
    public static class StatusCountRespDto {
        private Integer id;
        private Integer statusAll;
        private Integer statusC;
        private Integer statusFinal;
    }

    @NoArgsConstructor
    @Setter
    @Getter
    public static class InfoAllRespDto {
        List<InfoRespDto> infoRespDtos;
        List<InfoCountRespDto> infoCountRespDtos;
        List<RecommendByPositionRespDto> recommendByPositionRespDtos;
        List<StatusCountRespDto> statusCountRespDtos;

        public InfoAllRespDto(List<InfoRespDto> infoRespDtos, List<InfoCountRespDto> infoCountRespDtos,
                List<RecommendByPositionRespDto> recommendByPositionRespDtos,
                List<StatusCountRespDto> statusCountRespDtos) {
            this.infoRespDtos = infoRespDtos;
            this.infoCountRespDtos = infoCountRespDtos;
            this.recommendByPositionRespDtos = recommendByPositionRespDtos;
            this.statusCountRespDtos = statusCountRespDtos;
        }
    }
    /* >>>>> 서현 작업 종료 <<<<< */
}
