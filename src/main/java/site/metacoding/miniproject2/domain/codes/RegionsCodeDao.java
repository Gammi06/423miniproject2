package site.metacoding.miniproject2.domain.codes;

import java.util.List;

import site.metacoding.miniproject2.dto.CodesRespDto.RegionsCodeRespDto;

public interface RegionsCodeDao {

    public List<RegionsCodeRespDto> findAll();

    public RegionsCodeRespDto findById(Integer id);

}
