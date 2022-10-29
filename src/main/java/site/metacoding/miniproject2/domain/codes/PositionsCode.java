package site.metacoding.miniproject2.domain.codes;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PositionsCode {
    private Integer id;
    private String name;
    private Timestamp created;

    @Builder
    public PositionsCode(Integer id, String name, Timestamp created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }
}
