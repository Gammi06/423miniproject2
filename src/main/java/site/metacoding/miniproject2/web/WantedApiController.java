package site.metacoding.miniproject2.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;
import site.metacoding.miniproject2.service.WantedsService;

@RequiredArgsConstructor
@RestController
public class WantedApiController {

    private final WantedsService wantedsService;
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
}
