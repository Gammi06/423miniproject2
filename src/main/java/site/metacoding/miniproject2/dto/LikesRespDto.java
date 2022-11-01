package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class LikesRespDto {

    /* >>>> 승현 작업함 <<<< */

    /* 기존 작업자 : 지원 */
    @Setter
    @Getter
    public static class LikeRespDto {
        private Integer id;
        private String title;
        private Integer companysId;
        private String companyName;
        private String state;
    }

    /*
     * /////////////////////////////////////////
     * LikeListRespDto 삭제 내용:
     * detail: detailDto에서 사용 예정 => 필요시 추가 가능
     * photo: api컨트롤러 사용이라 삭제함
     * currnetTimestamp: 현재 시간이 필요하지 않을 것 같아서 삭제함
     * created, ended : 한방 쿼리로 state로 가져올 예정이라 삭제함
     * datePart. day: 겹치는 내용이라 삭제함
     * /////////////////////////////////////////
     */

    @Setter
    @Getter
    public static class LikeFideByIdRespDto {
        private Integer id;
        private Integer userId;
        private Integer wantedId;
        private Timestamp created;
    }

    /* >>>> 승현 작업 종료 <<<< */
}
