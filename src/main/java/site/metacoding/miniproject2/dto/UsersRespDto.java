package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.miniproject2.domain.users.Users;
import site.metacoding.miniproject2.dto.EducationsRespDto.EducationsListRespDto;

public class UsersRespDto {

    /* >>>>> 성유 작업함 <<<<< */
    @Getter
    @Setter
    public static class UsersInfoRespDto { // findById (이것만 Users 적음)
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
        private String userId;
        private String userPassword;
        private String userName;
        private Integer age;
        private String phoneNumber;
        private String email;

        public JoinRespDto(Users users) {
            this.userId = users.getUserId();
            this.userPassword = users.getUserPassword();
            this.userName = users.getUserName();
            this.age = users.getAge();
            this.phoneNumber = users.getPhoneNumber();
            this.email = users.getEmail();
        }
    }

    @Getter
    @Setter
    public static class EditRespDto { // 기본정보 수정
        private String userName;
        private String email;
        private String phoneNumber;
    }

    @Getter
    @Setter
    public static class ProfileEditRespDto { // 프로필 수정
        private String positionCodeName;
        private Integer positionCodeId;
        private Integer mycareerId;
        private Integer skillsCodeId;
        private List<EducationsListRespDto> educationsListRespDtos;
        private String intro; // 간단 소개글 (Resunes)

    }

    /* >>>>> 성유 작업 종료<<<<< */

    /* >>>>> 서현 작업함 <<<<< */
    @Setter
    @Getter
    public class InfoRespDto {
        private Integer id;
        private String userName;
        private String phoneNumber;
        private String email;
        private Integer positionCodeId;
        private String positionCodeName;
    }

    @Setter
    @Getter
    public class InfoCountRespDto {
        private Integer id;
        private Integer statusAll;
        private Integer likesCount;
        private Integer subscribesCount;
        private Integer requestsCount;
    }

    @Setter
    @Getter
    public class RecommendByPositionRespDto {
        private Integer id;
        private Integer no;
        private String companyName;
        private String title;
        private String detail;
    }

    @Setter
    @Getter
    public class StatusCountRespDto {
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
