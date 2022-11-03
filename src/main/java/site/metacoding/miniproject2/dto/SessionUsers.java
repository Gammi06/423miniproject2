package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.UsersReqDto.AuthReqDto;

@Setter
@Getter
public class SessionUsers {
    private Integer id;
    private String userId;
    private String role; // '일반' = users (디폴트값), '회사' = companys

    public SessionUsers(AuthReqDto authReqDto) {
        this.id = authReqDto.getId();
        this.userId = authReqDto.getUserId();
        this.role = authReqDto.getRole();
    }
}