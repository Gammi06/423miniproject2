package site.metacoding.miniproject2.domain.wanteds;

import java.util.List;

import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;

public interface WantedsDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    public WantedDetailRespDto findById(Integer id);

    public List<WantedListRespDto> findAll();

    public List<WantedListRespDto> findAllOrdered(SearchDto searchDto);

    public List<WantedListRespDto> findAllByCompanyId(Integer companyId);

    public List<WantedListRespDto> findAllByPositionCodeName(String positionCodeName);

    public List<WantedListRespDto> findAllByLike(Integer userId);

    public void insert();

    public void updateById(Integer id);

    public void deleteById(Integer id);

    public void findByCompanysId(Integer companyId);

    public void findByCareersId(Integer companyId, Integer careerCodeId);

    public void findByPositionsId();

    public void findByBothIds();

    /* ///////// 삭제 내역 //////// */
    // public void findAllByPosition();
    // public void findAllHot();

    // public void findBestHot();
}
