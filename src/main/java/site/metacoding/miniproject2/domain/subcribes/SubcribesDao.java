package site.metacoding.miniproject2.domain.subcribes;

import java.util.List;

import site.metacoding.miniproject2.dto.SubribesRespDto.SubscribesListRespDto;

public interface SubcribesDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    /* >>>>>>지원 작업함<<<<<<< */
    public List<SubscribesListRespDto> subcribesListPage(Integer id);
}
/* >>>>>>>>지원 작업 종료<<<<<<<<<<<< */
