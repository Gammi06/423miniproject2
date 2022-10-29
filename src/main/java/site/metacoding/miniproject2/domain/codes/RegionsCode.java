package site.metacoding.miniproject2.domain.codes;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegionsCode {
    private Integer id;
    private String name;
    private Timestamp created;

    @Builder
    public RegionsCode(Integer id, String name, Timestamp created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }
}
