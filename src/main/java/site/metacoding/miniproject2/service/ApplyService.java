package site.metacoding.miniproject2.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.applys.ApplysDao;
import site.metacoding.miniproject2.domain.resumes.ResumesDao;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyFindReqDto;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;
import site.metacoding.miniproject2.dto.ApplyRespDto.ApplyFindByIdRespDto;
import site.metacoding.miniproject2.dto.ApplyRespDto.ApplyInsertRespDto;

@RequiredArgsConstructor
@Service
public class ApplyService {

    private final ResumesDao resumesDao;
    private final ApplysDao applysDao;
    private final HttpSession session;

    /* 승현 작업 시작 */

    public ApplyInsertRespDto insert(ApplyUserReqDto applyUserReqDto) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        /*
         * if (principal.getUserId().isEmpty()) {
         * throw new RuntimeException("로그인 해주세요.");
         * }
         * // 이력서를 작성한 유저와 현재 로그인한 유저의 아이디가 맞는지 비교하기
         * // if (resumesDao.findById(applyUserReqDto.getResumeId()).getUserId() !=
         * // principal.getUserId()) {
         * // throw new RuntimeException("신청하실 이력서가 없습니다.");
         * // }
         * if (applyUserReqDto.getResumeId() == 0) {
         * throw new RuntimeException("신청하실 이력서가 없습니다.");
         * }
         */
        applysDao.insert(applyUserReqDto);
        return ApplyInsertRespDto.builder()
                .resumeId(applyUserReqDto.getResumeId())
                .wantedId(applyUserReqDto.getWantedId())
                .build();
    }

    public ApplyFindByIdRespDto findByApplyId(Integer id) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getUserId().isEmpty()) {
            throw new RuntimeException("로그인 해주세요.");
        }
        ApplyFindReqDto applyFindReqDto = ApplyFindReqDto.builder().userId(null).wantedId(id).build();
        return applysDao.findApply(applyFindReqDto);
    }

    /* 승현 작업 종료 */
}
