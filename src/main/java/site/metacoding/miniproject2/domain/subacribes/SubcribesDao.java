package site.metacoding.miniproject2.domain.subacribes;

import java.util.List;

import site.metacoding.miniproject2.dto.CompanysRespDto.SubscribesListRespDto;
import site.metacoding.miniproject2.dto.SubribesReqDto.SubcribesInsertReqDto;
import site.metacoding.miniproject2.dto.SubribesRespDto.SubribesFindByIdRespDto;

public interface SubcribesDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    /* >>>>>>지원 작업함<<<<<<< */

    public List<SubscribesListRespDto> subcribesListPage(Integer userId);

    /* >>>>>>>>지원 작업 종료<<<<<<<<<<<< */

    /* 승현 작업함 */

    public SubribesFindByIdRespDto findById(Integer id);

    public void insert(SubcribesInsertReqDto subcribesInsertReqDto);

    public void deleteById(Integer id);

    /* 승현 작업 종료 */

}