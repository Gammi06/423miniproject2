package site.metacoding.miniproject2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.subcribes.Subcribes;

public class SubribesReqDto {

    @Getter
    @Setter
    public static class SubcribesInsertReqDto {
        private Integer userId;
        private Integer comanyId;

        @Builder
        public Subcribes toEntity() {
            return Subcribes
                    .builder()
                    .userId(userId)
                    .companyId(comanyId)
                    .build();
        }
    }
}
