package site.metacoding.miniproject2.domain.subcribes;

import java.util.List;

import site.metacoding.miniproject2.dto.SubribesRespDto.SubscribesListRespDto;

public interface SubcribesDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    /* >>>>>>지원 작업함<<<<<<< */

    public List<SubscribesListRespDto> subcribesListPage(Integer id);

    /* >>>>>>>>지원 작업 종료<<<<<<<<<<<< */

    /* 승현 작업함 */

    public void findById(Integer id);

    public void insert();

    public void deleteById(Integer id);

    /* 승현 작업 종료 */

}