package site.metacoding.miniproject2.domain.users;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Users {
    private Integer id;
    private String userId;
    private String userPassword;
    private String userName;
    private Integer age;
    private String phoneNumber;
    private String email;
    private String photo;
    private Integer positionCodeId;
    private Integer mycareerId;
    private Timestamp created;
    private String role; // '일반'(디폴트) , '회사'

    @Builder
    public Users(Integer id, String userId, String userPassword, String userName, Integer age, String phoneNumber,
            String email, String photo, String positionCodeName, Integer positionCodeId,
            Integer mycareerId, Timestamp created, String role) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.photo = photo;
        this.positionCodeId = positionCodeId;
        this.mycareerId = mycareerId;
        this.created = created;
        this.role = role;
    }
    /*
     * //////////////////////////////////
     * positionCodeName이 원래 존재했지만 중복으로 필요하지 않기 때문에 삭제
     * //////////////////////////////////
     */

}
