package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.users.Users;

@Getter
@Setter
public class SessionUsers {
    private Integer id;
    private String userId;

    public SessionUsers(Users users) {
        this.id = users.getId();
        this.userId = users.getUserId();
    }

}