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
import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsSaveReqDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsUpdateReqDto;
import site.metacoding.miniproject2.handler.MyApiException;
import site.metacoding.miniproject2.service.ApplyService;
import site.metacoding.miniproject2.service.LikesService;
import site.metacoding.miniproject2.service.WantedsService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class WantedApiController {

    private final HttpSession session;
    private final WantedsService wantedsService;
    private final LikesService likesService;
    private final ApplyService applyService;

    /* 승현 작업 시작 */

    @GetMapping("/wanted")
    public CMRespDto<?> findAll() {
        return new CMRespDto<>(1, "성공", wantedsService.findAll());
    }

    @GetMapping("/wanted/{wantedId}")
    public CMRespDto<?> findById(@PathVariable Integer wantedId) {
        return new CMRespDto<>(1, "성공", wantedsService.findById(wantedId));
    }

    @GetMapping("/s/api/wanted/like")
    public CMRespDto<?> findAllByLike() {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getId() == null) {
            throw new MyApiException("로그인이 필요합니다.");
        }
        return new CMRespDto<>(1, "성공", wantedsService.findAllByLike(principal.getId()));
    }

    @GetMapping("/wanted/position/{id}")
    public CMRespDto<?> findAllByPositionCodeId(@PathVariable Integer id) {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByPositionCodeId(id));
    }

    @GetMapping("/wanted/company/{companyId}")
    public CMRespDto<?> findAllByCompanyId(@PathVariable Integer companyId) {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByCompanyId(companyId));
    }

    @PostMapping("/s/api/wanted/{id}/like")
    public CMRespDto<?> insertLike(@PathVariable Integer id, LikesInsertReqDto likesInsertReqDto) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getId() == null) {
            throw new MyApiException("로그인이 필요합니다.");
        }
        likesInsertReqDto.setWantedId(id);
        likesInsertReqDto.setUserId(principal.getId());
        return new CMRespDto<>(1, "성공", likesService.insert(likesInsertReqDto));
    }

    @DeleteMapping("/s/api/wanted/{id}/like")
    public CMRespDto<?> deleteLike(@PathVariable Integer id, LikesInsertReqDto likesInsertReqDto) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getId() == null) {
            throw new MyApiException("로그인이 필요합니다.");
        }
        likesInsertReqDto.setUserId(principal.getId());
        likesInsertReqDto.setWantedId(id);
        likesService.delete(likesInsertReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    @PostMapping("/s/api/wanted/{id}/apply/add")
    public CMRespDto<?> insertApply(@PathVariable Integer id, @RequestBody ApplyUserReqDto applyUserReqDto) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        if (principal.getId() == null) {
            throw new MyApiException("로그인이 필요합니다.");
        }
        applyUserReqDto.setWantedId(id);
        return new CMRespDto<>(1, "성공", applyService.insert(applyUserReqDto));
    }

    /* 승현 작업 종료 */

    /* 수현 작업 시작 */
    @PostMapping("/s/api/wanted/{companysId}/add")
    public CMRespDto<?> save(@PathVariable Integer companysId, @RequestBody WantedsSaveReqDto wantedsSaveReqDto) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        wantedsSaveReqDto.setCompanysId(principal.getCompanyId());
        return new CMRespDto<>(1, "성공", wantedsService.save(wantedsSaveReqDto));
    }

    @PutMapping("/s/api/wanted/{wantedId}/edit")
    public CMRespDto<?> update(@PathVariable Integer wantedId, @RequestBody WantedsUpdateReqDto wantedsUpdateReqDto) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        wantedsUpdateReqDto.setId(wantedId);
        wantedsUpdateReqDto.setCompanysId(principal.getCompanyId());
        return new CMRespDto<>(1, "성공", wantedsService.update(wantedsUpdateReqDto));
    }

    @DeleteMapping("/s/api/wanted/{wantedId}/delete")
    public CMRespDto<?> deleteById(@PathVariable Integer wantedId) {
        wantedsService.deleteById(wantedId);
        return new CMRespDto<>(1, "성공", null);
    }
    /* 수현 작업 종료 */
}
