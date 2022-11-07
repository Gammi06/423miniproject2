package site.metacoding.miniproject2.domain.applys;

import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;
import site.metacoding.miniproject2.dto.ApplyRespDto.ApplyFindByIdRespDto;

public interface ApplysDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    public ApplyFindByIdRespDto findApply(ApplyUserReqDto applyFindReqDto);

    public void insert(ApplyUserReqDto applyUserReqDto);
}
