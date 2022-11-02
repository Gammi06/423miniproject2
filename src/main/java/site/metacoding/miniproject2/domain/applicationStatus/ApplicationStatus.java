package site.metacoding.miniproject2.domain.applicationStatus;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ApplicationStatus {
    private Integer id;
    private Integer wantedId;
    private Integer resumeId;
    private Integer state;
    private Timestamp created;

    @Builder
    public ApplicationStatus(Integer id, Integer wantedId, Integer resumeId, Integer state, Timestamp created) {
        this.id = id;
        this.wantedId = wantedId;
        this.resumeId = resumeId;
        this.state = state;
        this.created = created;
    }
}
