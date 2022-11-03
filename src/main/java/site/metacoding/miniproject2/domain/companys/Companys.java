package site.metacoding.miniproject2.domain.companys;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Companys {
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

    @Builder
    public Companys(Integer id, Integer usersId, String companyName, String address, String email,
            String companyNumber, String photo,
            String regionCodeName, String intro, Integer years, Integer memberCount, Timestamp created) {
        this.id = id;
        this.usersId = usersId;
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
