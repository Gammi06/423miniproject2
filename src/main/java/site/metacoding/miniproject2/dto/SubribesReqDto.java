package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;

public class SubribesReqDto {

    @Getter
    @Setter
    public static class SubcribesInsertReqDto {
        private Integer userId;
        private Integer companyId;
        
        public SubcribesInsertReqDto(Integer userId, Integer companyId) {
            this.userId = userId;
            this.companyId = companyId;
        }
    }
}
