package site.metacoding.miniproject2.domain.requests;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Requests {
    private Integer id;
    private Integer resumeId;
    private String status;
    private Timestamp created;

    @Builder
    public Requests(Integer id, Integer resumeId, String status, Timestamp created) {
        this.id = id;
        this.resumeId = resumeId;
        this.status = status;
        this.created = created;
    }
}
