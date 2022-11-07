
package site.metacoding.miniproject2.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.users.Users;
import site.metacoding.miniproject2.dto.EducationsRespDto.EducationsResumeRespDto;
import site.metacoding.miniproject2.dto.MyCareersRespDto.MyCareersEditRespDto;
import site.metacoding.miniproject2.dto.MySkillsRespDto.WantedsSkillsRespDto;

public class UsersReqDto {

    /* >>>>> 성유 작업함 <<<<< */
    @Getter
    @Setter
    public static class LoginReqDto {
        private String userId;
        private String userPassword; // 비밀번호 숨기기
    }

    @Getter
    @Setter
    public static class JoinReqDto {
        private String userId;
        private String userPassword; // 비밀번호 숨기기
        private String userName;
        private Integer age;
        private String phoneNumber;
        private String email;

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
    public static class EditReqDto {
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
    public static class ProfileEditRepDto {
        private Integer id;
        private String positionCodeName;
        private String careersCodeName;
        private List<WantedsSkillsRespDto> wantedsSkillsRespDtos;
        private List<MyCareersEditRespDto> myCareersEditRespDtos;
        private List<EducationsResumeRespDto> educationsResumeRespDtos; // educationsListRespDto ->
                                                                        // educationsResumeRespDto로 수정됨 : 연지
        private String intro;

        public ProfileEditRepDto(Integer id, String positionCodeName, String careersCodeName,
                List<WantedsSkillsRespDto> wantedsSkillsRespDtos, List<MyCareersEditRespDto> myCareersEditRespDtos,
                List<EducationsResumeRespDto> educationsListRespDtos, String intro) { // educationsListRespDto ->
                                                                                      // educationsResumeRespDto로 수정됨 :
                                                                                      // 연지
            this.id = id;
            this.positionCodeName = positionCodeName;
            this.careersCodeName = careersCodeName;
            this.wantedsSkillsRespDtos = wantedsSkillsRespDtos;
            this.myCareersEditRespDtos = myCareersEditRespDtos;
            this.educationsResumeRespDtos = educationsResumeRespDtos; // educationsListRespDto ->
                                                                      // educationsResumeRespDto로 수정됨 : 연지
            this.intro = intro;
        }

    }

    @Getter
    @Setter
    public static class PasswordReqDto { // 비밀번호 변경 (추후에 암호화 할 예정)
        private Integer id;
        private String userPassword;
    }
    /* >>>>> 성유 작업함 <<<<< */
}
