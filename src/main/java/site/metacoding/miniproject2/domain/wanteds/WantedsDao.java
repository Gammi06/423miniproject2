package site.metacoding.miniproject2.domain.wanteds;

import java.util.List;

import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;

public interface WantedsDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    /* >>>> 승현 작업 시작 <<<< */
    public WantedDetailRespDto findById(Integer id);

    public List<WantedListRespDto> findAll(SearchDto searchDto);

    public List<WantedListRespDto> findAllByCompanyId(Integer companyId);

    public List<WantedListRespDto> findAllByPositionCodeId(Integer positionCodeId);

    /* >>>> 승현 작업 종료 <<<< */

    /* ///////// 삭제 예정 내역 //////// */

    // public void findAllByPosition();
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

    public void findByBoth();
}
