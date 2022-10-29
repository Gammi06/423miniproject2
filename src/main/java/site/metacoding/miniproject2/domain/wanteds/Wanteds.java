package site.metacoding.miniproject2.domain.wanteds;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Wanteds {
    private Integer id;
    private Integer positionCodeId;
    private Integer careerCodeId;
    private String pay;
    private Integer companyId;
    private String title;
    private String detail;
    private Integer viewCount;
    private Timestamp created;
    private Timestamp enddate;
    private Boolean checked;

    @Builder
    public Wanteds(Integer id, Integer positionCodeId, Integer careerCodeId, String pay, Integer companyId,
            String title, String detail, Integer viewCount, Timestamp created, Timestamp enddate, Boolean checked) {
        this.id = id;
        this.positionCodeId = positionCodeId;
        this.careerCodeId = careerCodeId;
        this.pay = pay;
        this.companyId = companyId;
        this.title = title;
        this.detail = detail;
        this.viewCount = viewCount;
        this.created = created;
        this.enddate = enddate;
        this.checked = checked;
    }
}
