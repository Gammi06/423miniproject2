package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;

public class LikesReqDto {

	@Getter
	@Setter
	public class LikesInsertReqDto {
		private Integer userId;
		private Integer wantedId;
	}

}
