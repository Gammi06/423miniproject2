package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.miniproject2.domain.companys.Companys;

/*>>>>>>지원 작업함<<<<<<< */
/*기존 작업자 지원 */

public class CompanysReqDto {

    @Setter
    @Getter
    public static class CompanysTitleReqDto {
        private Integer id;
        private Integer usersId;
        private String companyName;
        private String address;
        private String email;
        private String companyNumber;
        private String photo;
        private String regionCodeName;
        private String intro;
        private Integer years;
        private Integer memberCount;
        private Timestamp created;

    }

    @NoArgsConstructor
    @Setter
    @Getter
    public static class CompanysInsertReqDto {
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

        public CompanysInsertReqDto(Companys companys) {
            this.id = companys.getId();
            this.companyName = companys.getCompanyName();
            this.address = companys.getAddress();
            this.email = companys.getEmail();
            this.companyNumber = companys.getCompanyNumber();
            this.regionCodeName = companys.getRegionCodeName();
            this.intro = companys.getIntro();
            this.years = companys.getYears();
            this.memberCount = companys.getMemberCount();
            this.usersId = companys.getUsersId();
        }

        // public Companys toEntity() {
        // return Companys.builder()
        // .id(id)
        // .companyName(companyName)
        // .address(address)
        // .email(email)
        // .companyNumber(companyNumber)
        // .regionCodeName(regionCodeName)
        // .intro(intro)
        // .years(years)
        // .memberCount(memberCount)
        // .usersId(usersId)
        // .build();
        // }

        // public void setSessionUsers(SessionUsers sessionUsers) {
        // }
    }

    @Setter
    @Getter
    public static class CompanysUpdateReqDto {
        private Integer usersId;
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
    }/* 지원 작업 종료 */

    /* 수현 작업함 */
    @NoArgsConstructor
    @Setter
    @Getter
    public static class CompanysUpdateIntroReqDto {
        private String intro;

        public CompanysUpdateIntroReqDto(String intro) {
            this.intro = intro;
        }

        public Companys toEntity() {
            return Companys.builder()
                    .intro(intro)
                    .build();
        }
    }
    /* 수현 작업 종료 */

}
