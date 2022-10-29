package site.metacoding.miniproject2.domain.recruits;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Recruits {
    private Integer id;
	private Integer resumeId;
	private Integer wantedId;
	private Timestamp created;

    @Builder
    public Recruits(Integer id, Integer resumeId, Integer wantedId, Timestamp created) {
        this.id = id;
        this.resumeId = resumeId;
        this.wantedId = wantedId;
        this.created = created;
    }
}
