package site.metacoding.miniproject2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.dto.UsersRespDto.AuthRespDto;

@Setter
@Getter
public class SessionUsers {
    public final String getRole = null;
    private Integer id;
    private String userId;
    private String role; // '일반' = users (디폴트값), '회사' = companys
    private Integer companyId;

    public SessionUsers(AuthRespDto authRespDto) {
        this.id = authRespDto.getId();
        this.userId = authRespDto.getUserId();
        this.role = authRespDto.getRole();
        this.companyId = authRespDto.getCompanyId();
    }

    @Builder
    public SessionUsers(Integer id, String userId, String role, Integer companyId) {
        this.id = id;
        this.userId = userId;
        this.role = role;
        this.companyId = companyId;
    }
}