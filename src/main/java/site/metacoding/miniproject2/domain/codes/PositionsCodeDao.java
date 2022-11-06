package site.metacoding.miniproject2.domain.codes;

import java.util.List;

import site.metacoding.miniproject2.dto.CodesRespDto.PositionsCodeRespDto;

public interface PositionsCodeDao {

    public List<PositionsCodeRespDto> findAll();

    public PositionsCodeRespDto findById(Integer id);

    public PositionsCodeRespDto findByCodename(String codename);

}
