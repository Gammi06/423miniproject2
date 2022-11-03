package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*기존 작업자 지원 */
public class SubribesRespDto {

        @Getter
        @Setter
        public static class SubribesFindByIdRespDto {
                private Integer id;
                private Integer userId;
                private Integer companyId;
                private Timestamp created;
        }

}

/*
 * datePart,day :겹치는 내용
 * private Timestamp currnetTimestamp; :현재시간 필요하지 않으듯 해서 삭제
 * SubscribesListRespDto -> CompaysRespDto 로 위치 변경했습니다.
 */
