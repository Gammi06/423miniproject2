package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.miniproject2.domain.companys.Companys;
//import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsListRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;

/*>>>>>>지원 작업함<<<<<<<*/
/*기존 작업자 승현/수현 */
public class CompanysRespDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class CompanysInsertRespDto {
        private Integer id;
        private String companyName;
        private String address;
        private String email;
        private String companyNumber;
        private String regionCodeName;
        private String intro;
        private Integer years;
        private Integer memberCount;
        private Integer usersId;

    }

    @Getter
    @Setter
    public static class CompanysDeleteRespDto {
        private Integer id;
        private String companyName;
        List<String> wantedNameListCompany;
    }

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

    @Getter
    @Setter
    public static class CompanysNumberCheckRespDto {
        private String companyNumber;

    }

    @Getter
    @Setter
    public static class CompanyDetailWithWantedsListRespDto {
        private CompanyDetailRespDto companyDetailRespDto;
        private List<WantedListRespDto> wantedsListRespDtos;
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

    @NoArgsConstructor
    @Getter
    @Setter
    public static class SubscribesListRespDto {
        private Integer id;
        private Integer userId;
        private Integer companyId;
        private Integer wantedId;
        private String companyName;
        private Timestamp created;// 공고시작시간
        private Timestamp enddate;// 공고끝나는시간
        private String state;

        public SubscribesListRespDto(SubscribesListRespDto subscribesListRespDto) {
            this.userId = subscribesListRespDto.getUserId();
            this.companyId = subscribesListRespDto.getCompanyId();
            this.wantedId = subscribesListRespDto.getWantedId();
            this.companyName = subscribesListRespDto.getCompanyName();
            this.created = subscribesListRespDto.getCreated();
            this.enddate = subscribesListRespDto.getEnddate();
            this.state = subscribesListRespDto.getState();
        }

    }

    @Setter
    @Getter
    public static class CompanysUpdateIntroRespDto {
        private String intro;

        public CompanysUpdateIntroRespDto(Companys companys) {
            this.intro = intro;
        }
    }

}

/*
 * >>>>>>>>지원 작업 종료<<<<<<<<<<<
 * List<WantedsListDto> wantedsListDtos; : Dto2개 연결이라서 삭제
 * photo; : api 컨롤러 사용이라서 삭제
 * CompanyDetailWithWantedsListRespDto 는 CompanyDetailRespDto와 같이 같아서 삭제 -> 필요해서
 * 다시 넣어둠 물어보고 삭제예정
 * PagingRespDto pagingDto; PagingRespDto와 같아서 삭제.
 * PagingWantedsManageRespDto안에 같이 포함이 되어있어서 삭제예정
 * List<WantedsManageDto> :Dto2개 연결이라서 삭제
 *
 */