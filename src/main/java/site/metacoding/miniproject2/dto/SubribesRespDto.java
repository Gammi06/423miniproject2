package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.SubribesReqDto.SubcribesInsertReqDto;

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

        /* 승현 작업 시작 */
        @Setter
        @Getter
        public static class SubcribesInsertRespDto {
                private Integer userId;
                private Integer companyId;

                public SubcribesInsertRespDto(SubcribesInsertReqDto subcribesInsertReqDto) {
                        this.userId = subcribesInsertReqDto.getUserId();
                        this.companyId = subcribesInsertReqDto.getCompanyId();
                }
        }
        /* 승현 작업 종료 */
}