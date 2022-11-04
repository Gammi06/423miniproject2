package site.metacoding.miniproject2.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsSaveReqDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsUpdateReqDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;
import site.metacoding.miniproject2.service.ApplyService;
import site.metacoding.miniproject2.service.LikesService;
import site.metacoding.miniproject2.service.WantedsService;

@RequiredArgsConstructor
@RestController
public class WantedApiController {

    private final WantedsService wantedsService;
    private final LikesService likesService;
    private final ApplyService applyService;

    /* 승현 작업 시작 */

    // 공고 전체 목록 보기
    @GetMapping("/wanted")
    public List<WantedListRespDto> findAll(SearchDto searchDto) {
        return wantedsService.findAll(searchDto);
    }

    @GetMapping("/wanted/{wantedId}")
    public CMRespDto<?> findById(@PathVariable Integer wantedId) {
        return new CMRespDto<>(1, "성공", wantedsService.findById(wantedId));
    }

    // 좋아요 한 공고 목록 보기
    @GetMapping("/s/wanted/{userId}/like")
    public CMRespDto<?> findAllByLike(@PathVariable Integer userId) {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByLike(userId));
    }

    // 포지션 별 공고 목록 보기
    @GetMapping("/wanted/position/{positionCodeName}")
    public CMRespDto<?> findAllByPositionCodeName(@PathVariable String positionCodeName) {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByPositionCodename(positionCodeName));
    }

    // 회사의 공고 목록 보기
    @GetMapping("/wanted/position/{companyId}")
    public CMRespDto<?> findAllByCompanyId(@PathVariable Integer companyId) {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByCompanyId(companyId));
    }

    // 좋아요 추가하기
    @PostMapping("/s/api/wanted/{id}/like")
    public CMRespDto<?> insertLike(@PathVariable Integer id) {
        LikesInsertReqDto likesInsertReqDto = LikesInsertReqDto.builder().userId(null).wantedId(id).build();
        likesService.insert(likesInsertReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    // 좋아요 취소하기
    @DeleteMapping("/s/api/wanted/{id}/like")
    public CMRespDto<?> deleteLike(@PathVariable Integer id) {
        LikesInsertReqDto likesInsertReqDto = LikesInsertReqDto.builder().userId(null).wantedId(id).build();
        likesService.delete(likesInsertReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    // 지원하기 추가하기
    @PostMapping("/s/api/wanted/{id}/apply")
    public CMRespDto<?> insertApply(@PathVariable Integer id, ApplyUserReqDto applyUserReqDto) {
        applyService.insert(applyUserReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    /* 승현 작업 종료 */

    /* 수현 작업 시작 */
    @PostMapping("/s/api/wanted/{companysId}/add")
    public CMRespDto<?> save(@PathVariable Integer companysId, @RequestBody WantedsSaveReqDto wantedsSaveReqDto) {
        wantedsService.save(wantedsSaveReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    @PutMapping("/s/api/wanted/{companysId}/edit")
    public CMRespDto<?> update(@PathVariable Integer companysId, @RequestBody WantedsUpdateReqDto wantedsUpdateReqDto) {
        wantedsService.update(wantedsUpdateReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    @DeleteMapping("/s/api/wanted/{companysId}/delete")
    public CMRespDto<?> deleteById(@PathVariable Integer companysId) {
        wantedsService.deleteById(companysId);
        return new CMRespDto<>(1, "성공", null);
    }
    /* 수현 작업 종료 */
}
