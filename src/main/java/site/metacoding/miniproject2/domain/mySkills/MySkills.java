package site.metacoding.miniproject2.domain.mySkills;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MySkills {
    private Integer id;
    private Integer userId;
    private Integer resumeId;
    private Integer wantedId;
    private Integer skillsCodeId;

    @Builder
    public MySkills(Integer id, Integer userId, Integer resumeId, Integer wantedId, Integer skillsCodeId) {
        this.id = id;
        this.userId = userId;
        this.resumeId = resumeId;
        this.wantedId = wantedId;
        this.skillsCodeId = skillsCodeId;
    }
}
