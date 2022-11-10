package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.applys.ApplysDao;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;
import site.metacoding.miniproject2.dto.ApplyRespDto.ApplyInsertRespDto;
import site.metacoding.miniproject2.handler.MyApiException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ApplyService {

    private final ApplysDao applysDao;

    /* 승현 작업 시작 */

    @Transactional
    public ApplyInsertRespDto insert(ApplyUserReqDto applyUserReqDto) {
        if (applyUserReqDto.getResumeId() == null) {
            throw new MyApiException("신청하실 이력서가 없습니다.");
        }
        // 중복 확인
        if (applysDao.findApply(applyUserReqDto) != null) {
            throw new MyApiException("이미 동일한 이력서로 신청하셨습니다.");
        }
        // 이력서 유무확인 필요함 (콩지 작업 후 추가하기)
        applysDao.insert(applyUserReqDto);
        return new ApplyInsertRespDto(applyUserReqDto);
    }

    /* 승현 작업 종료 */
}
