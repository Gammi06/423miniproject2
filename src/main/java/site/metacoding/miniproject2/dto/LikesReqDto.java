package site.metacoding.miniproject2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class LikesReqDto {

	@Getter
	@Setter
	public static class LikesInsertReqDto {
		private Integer userId;
		private Integer wantedId;

		@Builder
		public LikesInsertReqDto(Integer userId, Integer wantedId) {
			this.userId = userId;
			this.wantedId = wantedId;
		}

	}

}
