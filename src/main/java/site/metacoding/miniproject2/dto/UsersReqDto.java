
package site.metacoding.miniproject2.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.users.Users;
import site.metacoding.miniproject2.dto.EducationsRespDto.EducationsListRespDto;
import site.metacoding.miniproject2.dto.MyCareersRespDto.MyCareersEditRespDto;
import site.metacoding.miniproject2.dto.MySkillsRespDto.WantedsSkillsRespDto;

public class UsersReqDto {

    /* >>>>> 성유 작업함 <<<<< */
    @Getter
    @Setter
    public static class LoginReqDto {
        private Integer id;
        private String userId;
        private String userPassword; // 비밀번호 숨기기
    }

    @Getter
    @Setter
    public static class AuthReqDto {
        private Integer id;
        private String userId;
        private String userPassword; // 비밀번호 숨기기
        private String role;
    }

    @Getter
    @Setter
    public static class JoinReqDto { // 회원가입
        private String userId;
        private String userPassword; // 비밀번호 숨기기
        private String userName;
        private Integer age;
        private String phoneNumber;
        private String email;
        /*
         * ////////////////////////////
         * photo: 이번에는 restController를 사용하기 때문에 삭제
         * ////////////////////////////
         */

        public Users toEntity() {
            return Users.builder()
                    .userId(userId)
                    .userPassword(userPassword)
                    .userName(userName)
                    .age(age)
                    .phoneNumber(phoneNumber)
                    .email(email)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class EditReqDto { // 기본정보 수정
        private Integer id;
        private String userName;
        private String email;
        private String phoneNumber;

        public Users toEntity() {
            return Users.builder()
                    .id(id)
                    .email(email)
                    .phoneNumber(phoneNumber)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class ProfileEditRepDto { // 프로필 수정
        private Integer id;
        private String positionCodeName;
        private String careersCodeName;
        private List<WantedsSkillsRespDto> wantedsSkillsRespDtos;
        private List<MyCareersEditRespDto> myCareersEditRespDtos;
        private List<EducationsListRespDto> educationsListRespDtos;
        private String intro;
    }

    @Getter
    @Setter
    public static class PasswordReqDto { // 비밀번호 변경 (추후에 암호화 할 예정)
        private Integer id;
        private String userPassword;
    }
    /* >>>>> 성유 작업함 <<<<< */
}
