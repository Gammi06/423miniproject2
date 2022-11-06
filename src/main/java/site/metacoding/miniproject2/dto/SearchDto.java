package site.metacoding.miniproject2.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {
    private Integer sortType;
    private String regionCodename;
    private Integer careerCodeId;
    private List<Integer> skillCodeId;
}
