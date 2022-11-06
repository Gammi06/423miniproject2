package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;

public class LikesReqDto {

	@Getter
	@Setter
	public static class LikesInsertReqDto {
		private Integer userId;
		private Integer wantedId;
	}

}
