package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.applys.ApplysDao;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyFindReqDto;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;
import site.metacoding.miniproject2.dto.ApplyRespDto.ApplyFindByIdRespDto;
import site.metacoding.miniproject2.dto.ApplyRespDto.ApplyInsertRespDto;

@RequiredArgsConstructor
@Service
public class ApplyService {

    private final ApplysDao applysDao;

    /* 승현 작업 시작 */

    public ApplyInsertRespDto insert(ApplyUserReqDto applyUserReqDto) {
        // 이력서를 작성한 유저와 현재 로그인한 유저의 아이디가 맞는지 비교하기
        // if (resumesDao.findById(applyUserReqDto.getResumeId()).getUserId() !=
        // principal.getUserId()) {
        // throw new RuntimeException("신청하실 이력서가 없습니다.");
        // }
        applysDao.insert(applyUserReqDto);
        return new ApplyInsertRespDto(applyUserReqDto);
    }

    public ApplyFindByIdRespDto findByApplyId(ApplyFindReqDto applyFindReqDto) {
        return applysDao.findApply(applyFindReqDto);
    }

    /* 승현 작업 종료 */
}
