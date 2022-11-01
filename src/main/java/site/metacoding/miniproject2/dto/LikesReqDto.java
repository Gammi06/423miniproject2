package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.likes.Likes;

public class LikesReqDto {

	/* >>>> 승현 작업함 <<<< */
	@Getter
	@Setter
	public static class LikesInsertReqDto {
		private Integer userId;
		private Integer wantedId;

		public Likes toEntity() {
			return Likes
					.builder()
					.userId(userId)
					.wantedId(wantedId)
					.build();
		}
	}
	
	/* >>>> <<<< */

}
