package site.metacoding.miniproject2.dto;

import lombok.Getter;
import lombok.Setter;

/* >>>> 연지 작업함 <<<< */
public class CodesRespDto {

	@Setter
	@Getter
	public static class CareersCodeRespDto {
		private Integer id;
		private String name;
	}

	@Setter
	@Getter
	public static class PositionsCodeRespDto {
		private Integer id;
		private String name;
	}

	@Setter
	@Getter
	public static class SkillsCodeRespDto {
		private Integer id;
		private String name;
	}

	@Setter
	@Getter
	public static class RegionsCodeRespDto {
		private Integer id;
		private String name;
	}

}
/* >>>> 연지 작업종료 <<<< */