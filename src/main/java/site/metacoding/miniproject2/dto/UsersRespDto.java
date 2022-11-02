package site.metacoding.miniproject2.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.EducationsRespDto.EducationsListRespDto;

public class UsersRespDto {

    /* >>>>> 성유 작업함 <<<<< */
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
}
