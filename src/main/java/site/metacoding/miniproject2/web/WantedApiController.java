package site.metacoding.miniproject2.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.service.LikesService;
import site.metacoding.miniproject2.service.WantedsService;

@RequiredArgsConstructor
@RestController
public class WantedApiController {

    private final WantedsService wantedsService;
    private final LikesService likesService;

    // 공고 전체 목록 보기
    @GetMapping("/api/wanted")
    public CMRespDto<?> findAll(SearchDto searchDto) {
        return new CMRespDto<>(1, "성공", wantedsService.findAll(searchDto));
    }

    // 공고 상세보기
    @GetMapping("/api/wanted/{wantedId}")
    public CMRespDto<?> findById(@PathVariable Integer wantedId) {
        return new CMRespDto<>(1, "성공", wantedsService.findById(wantedId));
    }

    // 좋아요 한 공고 목록 보기
    @GetMapping("/s/api/wanted/{userId}/like")
    public CMRespDto<?> findAllByLike(@PathVariable Integer userId) {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByLike(userId));
    }

    // 포지션 별 공고 목록 보기
    @GetMapping("/api/wanted/position/{positionCodeName}")
    public CMRespDto<?> findAllByPositionCodeName(@PathVariable String positionCodeName) {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByPositionCodename(positionCodeName));
    }

    // 회사의 공고 목록 보기
    @GetMapping("/api/wanted/position/{companyId}")
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
    public void wantedInsertApply(@PathVariable Integer id) {
        // userId에 유저 아이디값 넣어주기
    }

    // 지원하기
}
