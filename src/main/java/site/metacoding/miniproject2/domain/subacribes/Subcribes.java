package site.metacoding.miniproject2.domain.subacribes;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Subcribes {
    private Integer id;
    private Integer userId;
    private Integer companyId;
    private Timestamp created;
}
