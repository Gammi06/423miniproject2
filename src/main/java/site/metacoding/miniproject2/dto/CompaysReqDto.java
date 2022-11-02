package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.companys.Companys;

/*>>>>>>지원 작업함<<<<<<< */
/*기존 작업자 지원 */
public class CompaysReqDto {

    @Setter
    @Getter
    public static class CompanysInsertReqDto {
        private String companyName;
        private String address;
        private String email;
        private String companyNumber;
        private String regionCodeName;
        private String intro;
        private Integer years;
        private Integer memberCount;

        public Companys toEntity() {
            return Companys.builder()
                    .companyName(companyName)
                    .address(address)
                    .email(email)
                    .companyNumber(companyNumber)
                    .regionCodeName(regionCodeName)
                    .intro(intro)
                    .years(years)
                    .memberCount(memberCount)
                    .build();
        }
    }

    @Setter
    @Getter
    public static class CompanysUpdateReqDto {
        private String companyName;
        private String address;
        private String email;
        private String regionCodeName;
        private Integer memberCount;

        public Companys toEntity() {
            return Companys.builder()
                    .companyName(companyName)
                    .address(address)
                    .email(email)
                    .regionCodeName(regionCodeName)
                    .memberCount(memberCount)
                    .build();
        }
    }
}

/* 지원 작업 종료 */