package site.metacoding.miniproject2.domain.codes;

import java.util.List;

import site.metacoding.miniproject2.dto.CodesRespDto.SkillsCodeRespDto;

public interface SkillsCodeDao {

    public List<SkillsCodeRespDto> findAll();

    public SkillsCodeRespDto findById(Integer id);

}