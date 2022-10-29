package site.metacoding.miniproject2.domain.educations;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Educations {
    private Integer id;
    private Integer userId;
    private Integer resumeId;
    private Timestamp startdate;
    private Timestamp enddate;
    private String instruction;
    private String state;

    @Builder
    public Educations(Integer id, Integer userId, Integer resumeId, Timestamp startdate, Timestamp enddate,
            String instruction, String state) {
        this.id = id;
        this.userId = userId;
        this.resumeId = resumeId;
        this.startdate = startdate;
        this.enddate = enddate;
        this.instruction = instruction;
        this.state = state;
    }
}
