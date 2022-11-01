package site.metacoding.miniproject2.domain.applys;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Applys {
    private Integer id;
    private Integer wantedId;
    private Integer resumeId;
    private Integer status;
    private Timestamp created;

    @Builder
    public Applys(Integer id, Integer wantedId, Integer resumeId, Integer status, Timestamp created) {
        this.id = id;
        this.wantedId = wantedId;
        this.resumeId = resumeId;
        this.status = status;
        this.created = created;
    }
}
