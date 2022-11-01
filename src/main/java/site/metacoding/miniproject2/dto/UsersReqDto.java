package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.educations.Educations;
import site.metacoding.miniproject2.domain.users.Users;

public class UsersReqDto {

    /* >>>>> 성유 작업함 <<<<< */
    @Getter
    @Setter
    public static class LoginReqDto { // 로그인
        private Integer id;
        private String userId;
        private String userPassword;
    }

    @Getter
    @Setter
    public static class JoinReqDto { // 회원가입
        private String userId;
        private String userPassword;
        private String userName;
        private Integer age;
        private String phoneNumber;
        private String email;
        private String photo;

        public Users toEntity() {
            return Users.builder()
                    .userId(userId)
                    .userPassword(userPassword)
                    .userName(userName)
                    .age(age)
                    .phoneNumber(phoneNumber)
                    .email(email)
                    .photo(photo)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class EditReqDto { // 기본정보 수정
        private String photo;
        private String userName;
        private String email;
        private String phoneNumber;

        public Users toEdit() {
            return Users.builder()
                    .photo(photo)
                    .email(email)
                    .phoneNumber(phoneNumber)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class ProfileEditRepDto { // 프로필 수정
        private String positionCodeName;
        private Integer positionCodeId;
        private Integer mycareerId;
        private Integer skillsCodeId;
        // 학력은 DTO 가져오기
        private String intro; // 간단 소개글 (Resunes)

    }

    @Getter
    @Setter
    public static class PasswordReqDto { // 비밀번호 변경 (추후에 암호화 할 예정)
        private String userPassword;
    }
    /* >>>>> 성유 작업함 <<<<< */
}
