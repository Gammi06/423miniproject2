package site.metacoding.miniproject2.web;

import java.util.List;

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
import site.metacoding.miniproject2.dto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsSaveReqDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsUpdateReqDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;
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
    public List<WantedListRespDto> findAll() {
        return wantedsService.findAll();
    }

    @GetMapping("/wanted/{wantedId}")
    public CMRespDto<?> findById(@PathVariable Integer wantedId) {
        return new CMRespDto<>(1, "성공", wantedsService.findById(wantedId));
    }

    @GetMapping("/s/api/wanted/like")
    public CMRespDto<?> findAllByLike() {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByLike());
    }

    @GetMapping("/wanted/position/position/{id}")
    public CMRespDto<?> findAllByPositionCodeId(@PathVariable Integer id) {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByPositionCodeId(id));
    }

    // 검색하기
    @GetMapping("/wanted/search")
    public List<WantedListRespDto> findAllBySearch(@RequestBody SearchDto searchDto) {
        return wantedsService.findAllBySearch(searchDto);
    }

    @GetMapping("/wanted/position/company/{companyId}")
    public CMRespDto<?> findAllByCompanyId(@PathVariable Integer companyId) {
        return new CMRespDto<>(1, "성공", wantedsService.findAllByCompanyId(companyId));
    }

    @PostMapping("/s/api/wanted/{id}/like")
    public CMRespDto<?> insertLike(@PathVariable Integer id, LikesInsertReqDto likesInsertReqDto) {
        likesInsertReqDto.setWantedId(id);
        return new CMRespDto<>(1, "성공", likesService.insert(likesInsertReqDto));
    }

    @DeleteMapping("/s/api/wanted/{id}/like")
    public CMRespDto<?> deleteLike(@PathVariable Integer id, LikesInsertReqDto likesInsertReqDto) {
        likesInsertReqDto.setWantedId(id);
        likesService.delete(likesInsertReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    @PostMapping("/s/api/wanted/{id}/apply/add")
    public CMRespDto<?> insertApply(@PathVariable Integer id, @RequestBody ApplyUserReqDto applyUserReqDto) {
        applyUserReqDto.setWantedId(id);
        return new CMRespDto<>(1, "성공", applyService.insert(applyUserReqDto));
    }

    /* 승현 작업 종료 */

    /* 수현 작업 시작 */
    @PostMapping("/s/api/wanted/{companysId}/add")
    public CMRespDto<?> save(@PathVariable Integer companysId, @RequestBody WantedsSaveReqDto wantedsSaveReqDto) {
        wantedsSaveReqDto.setCompanysId(companysId);
        return new CMRespDto<>(1, "성공", wantedsService.save(wantedsSaveReqDto));
    }

    @PutMapping("/s/api/wanted/{wantedId}/edit")
    public CMRespDto<?> update(@PathVariable Integer wantedId, @RequestBody WantedsUpdateReqDto wantedsUpdateReqDto) {
        return new CMRespDto<>(1, "성공", wantedsService.update(wantedsUpdateReqDto));
    }

    @DeleteMapping("/s/api/wanted/{wantedId}/delete")
    public CMRespDto<?> deleteById(@PathVariable Integer wantedId) {
        wantedsService.deleteById(wantedId);
        return new CMRespDto<>(1, "성공", null);
    }
    /* 수현 작업 종료 */
}
