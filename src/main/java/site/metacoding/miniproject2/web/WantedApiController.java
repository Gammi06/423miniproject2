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
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsSaveReqDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsUpdateReqDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;
import site.metacoding.miniproject2.service.UsersService;
import site.metacoding.miniproject2.service.WantedsService;

@RequiredArgsConstructor
@RestController
public class WantedApiController {

    private final HttpSession session;
    private final WantedsService wantedsService;
    private final UsersService usersService;
    // private final LikesService likesService;
    // private final ApplyService applyService;

    @GetMapping("/api/wanted")
    public List<WantedListRespDto> findAll(SearchDto searchDto) {
        return wantedsService.findAll(searchDto);
    }

    @GetMapping("/api/wanted/{wantedId}")
    public WantedDetailRespDto findById(@PathVariable Integer wantedId) {
        return wantedsService.findById(wantedId);
    }

    @GetMapping("/s/api/wanted/{userId}/like")
    public List<WantedListRespDto> findAllByLike(@PathVariable Integer userId) {
        return wantedsService.findAllByLike(userId);
    }

    @GetMapping("/api/wanted/position/{positionCodeName}")
    public List<WantedListRespDto> findAllByPositionCodeName(@PathVariable String positionCodeName) {
        return wantedsService.findAllByPositionCodeName(positionCodeName);
    }

    @GetMapping("/api/wanted/position/{companyId}")
    public List<WantedListRespDto> findAllByCompanyId(@PathVariable Integer companyId) {
        return wantedsService.findAllByCompanyId(companyId);
    }

    @PostMapping("/s/api/wanted/{userId}/like")
    public void wantedInsertLike(@PathVariable Integer userId) {
        // userId에 유저 아이디값 넣어주기
    }

    @PostMapping("/s/api/wanted/{userId}/apply")
    public void wantedInsertApply(@PathVariable Integer userId) {
        // userId에 유저 아이디값 넣어주기
    }

    /* 수현 작업 시작 */
    @PostMapping("/s/api/wanted/{companysId}/add")
    public CMRespDto<?> save(@PathVariable Integer companysId, @RequestBody WantedsSaveReqDto wantedsSaveReqDto) {
        wantedsService.save(wantedsSaveReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    @PutMapping("/s/api/wanted/{wantedId}/edit")
    public CMRespDto<?> update(@PathVariable Integer wantedId, @RequestBody WantedsUpdateReqDto wantedsUpdateReqDto) {
        wantedsService.update(wantedsUpdateReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    @DeleteMapping("/s/api/wanted/{wantedId}/delete")
    public CMRespDto<?> deleteById(@PathVariable Integer wantedId) {
        wantedsService.deleteById(wantedId);
        return new CMRespDto<>(1, "성공", null);
    }
    /* 수현 작업 종료 */
}
