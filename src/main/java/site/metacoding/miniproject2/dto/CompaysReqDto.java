package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.companys.Companys;

/*>>>>>>지원 작업함<<<<<<< */
/*기존 작업자 지원 */

public class CompaysReqDto {

    @Setter
    @Getter
    public static class CompanysTitleReqDto {
        private Integer id;
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

        CompanysTitleReqDto(String companyName, String address, String email, String companyNumber, String photo,
                String regionCodeName,
                String intro, Integer years, Integer memberCount, Timestamp created) {
            this.companyName = companyName;
            this.address = address;
            this.email = email;
            this.companyNumber = companyNumber;
            this.photo = photo;
            this.regionCodeName = regionCodeName;
            this.intro = intro;
            this.years = years;
            this.memberCount = memberCount;
            this.created = created;
        }
    }

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

        public void setSessionUsers(SessionUsers sessionUsers) {
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

        public static void setId(Integer id) {
        }
    }

}

/* 지원 작업 종료 */