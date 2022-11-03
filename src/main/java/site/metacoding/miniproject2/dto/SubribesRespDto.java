package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*>>>>>>지원 작업함<<<<<<< */
/*기존 작업자 지원 */
public class SubribesRespDto {

        @ToString
        @Getter
        @Setter
        public static class SubscribesListRespDto {

                private Integer id;
                private Integer companysId;
                private Integer wantedsId;
                private String companyName;
                private Timestamp created;// 공고시작시간
                private Timestamp enddate;// 공고끝나는시간
                private String state;

                // 내일 보고 수정
                public SubscribesListRespDto(SubscribesListRespDto subcribes) {
                        this.id = id;
                        this.companysId = companysId;
                        this.wantedsId = wantedsId;
                        this.companyName = companyName;
                        this.created = created;
                        this.enddate = enddate;
                        this.state = state;
                }

                // public void add(SubscribesListRespDto subscribesListRespDto) {
                // }

        }

}
/*
 * >>>>>>>>지원 작업 종료<<<<<<<<<<<
 * datePart,day :겹치는 내용
 * private Timestamp currnetTimestamp; :현재시간 필요하지 않으듯 해서 삭제
 */