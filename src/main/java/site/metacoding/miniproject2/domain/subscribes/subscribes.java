package site.metacoding.miniproject2.domain.subscribes;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class subscribes {
    private Integer id;
    private Integer userId;
    private Integer companyId;
    private Timestamp created;
}
