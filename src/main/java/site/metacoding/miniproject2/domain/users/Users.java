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
	private String positionCodeName;
	private Integer positionCodeId;
	private Integer companyId;
	private Integer mycareerId;
	private Timestamp created;

    @Builder
    public Users(Integer id, String userId, String userPassword, String userName, Integer age, String phoneNumber,
            String email, String photo, String positionCodeName, Integer positionCodeId, Integer companyId,
            Integer mycareerId, Timestamp created) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.photo = photo;
        this.positionCodeName = positionCodeName;
        this.positionCodeId = positionCodeId;
        this.companyId = companyId;
        this.mycareerId = mycareerId;
        this.created = created;
    }
}
