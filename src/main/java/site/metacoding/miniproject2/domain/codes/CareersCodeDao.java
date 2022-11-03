package site.metacoding.miniproject2.domain.codes;

import java.util.List;

import site.metacoding.miniproject2.dto.CodesRespDto.CareersCodeRespDto;

public interface CareersCodeDao {

    public List<CareersCodeRespDto> findAll();

    public CareersCodeRespDto findById(Integer id);
}
