package site.metacoding.miniproject2.domain.likes;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Likes {
    private Integer id;
    private Integer userId;
    private Integer wantedId;
    private Timestamp created;

    @Builder
    public Likes(Integer id, Integer userId, Integer wantedId, Timestamp created) {
        this.id = id;
        this.userId = userId;
        this.wantedId = wantedId;
        this.created = created;
    }
}
