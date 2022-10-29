package site.metacoding.miniproject2.domain.myCareers;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyCareers {
    private Integer id;
    private Integer userId;
    private Integer resumeId;
    private Timestamp startdate;
    private Timestamp enddate;
    private String companyName;

    @Builder
    public MyCareers(Integer id, Integer userId, Integer resumeId, Timestamp startdate, Timestamp enddate,
            String companyName) {
        this.id = id;
        this.userId = userId;
        this.resumeId = resumeId;
        this.startdate = startdate;
        this.enddate = enddate;
        this.companyName = companyName;
    }
}
