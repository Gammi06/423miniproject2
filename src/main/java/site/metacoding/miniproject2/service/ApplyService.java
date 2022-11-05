package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.applys.ApplysDao;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyFindReqDto;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;
import site.metacoding.miniproject2.dto.ApplyRespDto.ApplyFindByIdRespDto;

@RequiredArgsConstructor
@Service
public class ApplyService {

    private final ApplysDao applysDao;

    /* 승현 작업 시작 */

    public void insert(ApplyUserReqDto applyUserReqDto) {
        applysDao.insert(applyUserReqDto);
    }

    public ApplyFindByIdRespDto findByApplyId(Integer id) {
        ApplyFindReqDto applyFindReqDto = ApplyFindReqDto.builder().userId(null).wantedId(id).build();
        return applysDao.findApply(applyFindReqDto);
    }

    /* 승현 작업 종료 */
}
