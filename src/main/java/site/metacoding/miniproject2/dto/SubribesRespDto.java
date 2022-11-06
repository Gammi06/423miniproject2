package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

                @Builder
                public SubcribesInsertRespDto(Integer userId, Integer companyId) {
                        this.userId = userId;
                        this.companyId = companyId;
                }
        }
        /* 승현 작업 종료 */
}