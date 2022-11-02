package site.metacoding.miniproject2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*>>>>>>지원 작업함<<<<<<<*/
/*기존 작업자 승현/수현 */
public class CompaysRespDto {

    @Getter
    @Setter
    public static class CompanyDetailRespDto {
        private Integer id;
        private String companyName;
        private String address;
        private String email;
        private String regionCodeName;
        private Integer memberCount;
        private String intro;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class CompanyInfoRespDto {
        private Integer id;
        private Integer no;
        private String companyName;
        private String title;
        private String detail;
    }

    @Getter
    @Setter
    public static class PagingRespDto {
        private Integer blockCount; // 상수 한페이지에 페이지 넘수 개수(16) 1-16
        private Integer currentBlock; // 변수
        private Integer startPageNum; // 변수 1 -> 17 -> 33
        private Integer lastPageNum; // 변수 16 -> 32 -> 48
        private Integer totalCount;
        private Integer totalPage;
        private Integer currentPage;
        private boolean isLast; // getter가 만들어지면 isLast() 이름으로 만들어짐. -> el에서는 last로 찾음
        private boolean isFirst; // getter가 만들어지면 isFirst() 이름으로 만들어짐. -> el에서는 first로 찾음
    }

    @Getter
    @Setter
    public static class PagingWantedsManageRespDto {
        private PagingRespDto pagingDto;
    }
}

/*
 * >>>>>>>>지원 작업 종료<<<<<<<<<<<
 * List<WantedsListDto> wantedsListDtos; : Dto2개 연결이라서 삭제
 * photo; : api 컨롤러 사용이라서 삭제
 * CompanyDetailWithWantedsListRespDto 는 CompanyDetailRespDto와 같이 같아서 삭제
 * PagingRespDto pagingDto; PagingRespDto와 같아서 삭제.
 * PagingWantedsManageRespDto안에 같이 포함이 되어있어서 삭제예정
 * List<WantedsManageDto> :Dto2개 연결이라서 삭제
 * 
 */