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

    public void findByBoth();

    public void insert();

    public void updateById();

    public void deleteById();

    // public void findAllHot();
    // public void findBestHot();
    // public void findAllWanteds();
    // public void findAllByCareer();
    // public void findAllByPositionToCompany();
    // public void findAllByCompanyId();
    // public void findByIdToDetail();
    // public void paging();
    // public void findAllToSort();
    // public void findAllLike();
    // public void findAllByposition();
}
