package site.metacoding.miniproject2.domain.resumes;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Resumes {
    private Integer id;
    private String userId;
    private Integer positionsCodeId;
    private String title;
    private String intro;
    private Integer statusId;
    private Timestamp created;

    @Builder
    public Resumes(Integer id, String userId, Integer positionsCodeId, String title, String intro, Integer statusId,
            Timestamp created) {
        this.id = id;
        this.userId = userId;
        this.positionsCodeId = positionsCodeId;
        this.title = title;
        this.intro = intro;
        this.statusId = statusId;
        this.created = created;
    }
}
