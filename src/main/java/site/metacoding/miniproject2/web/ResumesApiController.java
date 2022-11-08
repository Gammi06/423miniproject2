package site.metacoding.miniproject2.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.ResumesReqDto.ResumeUpdateReqDto;
import site.metacoding.miniproject2.dto.ResumesReqDto.ResumeWriteReqDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.service.ResumesService;

/* >>>> 연지 작업함 <<<< */
@RequiredArgsConstructor
@RestController
public class ResumesApiController {

    private final HttpSession session;
    private final ResumesService resumesService;

    /* 연지 작업 시작 */

    // 이력서 상세 조회
    @GetMapping("/s/api/resume/{id}")
    public CMRespDto<?> findById(@PathVariable Integer id) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getId() == null) {
            throw new RuntimeException("로그인이 필요합니다.");
        }
        return new CMRespDto<>(1, "성공", resumesService.findById(id));
    }

    // 이력서 목록 조회
    @GetMapping("/s/api/resume/list")
    public CMRespDto<?> findAllByUserId() {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getId() == null) {
            throw new RuntimeException("로그인이 필요합니다.");
        }
        return new CMRespDto<>(1, "성공", resumesService.findAllByUserId(principal.getId()));
    }

    // 이력서 추가
    @PostMapping("/s/api/resume/add")
    public void insert(@RequestBody ResumeWriteReqDto resumeWriteReqDto) {
        resumesService.insert(resumeWriteReqDto);
    }

    // 이력서 수정

    // 이력서 삭제
    // [Delete] Delete
    // 이력서id를 찾아서 해당 이력서 삭제하기
    @DeleteMapping("/s/api/resume/{id}/delete")
    public CMRespDto<?> deleteById(@PathVariable Integer id) {
        resumesService.deleteById(id);
        return new CMRespDto<>(1, "성공", null);
    }

    /* 연지 작업 완료 */

    // [Read] Selcet (findAllByUserId)
    // 유저id를 찾아서 그 유저의 이력서 목록 보여주기

    // [Update] Update
    // 이력서id를 찾아서 해당 이력서의
    // 제목/자기소개 수정되게, 경력/학력/스킬 추가/삭제되게 하고
    // 이력서 수정내용을 해당 이력서id에 반영하기
    @PutMapping("/s/api/resume/{id}/update")
    public void updateById(@PathVariable Integer id, @RequestBody ResumeUpdateReqDto resumeUpdateReqDto) {
        resumeUpdateReqDto.setId(id);
        resumesService.updateById(resumeUpdateReqDto);
        // return new CMRespDto<>(1, "성공", null);
    }

}
/* >>>> 연지 작업종료 <<<< */