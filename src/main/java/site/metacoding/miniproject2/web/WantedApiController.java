package site.metacoding.miniproject2.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;
import site.metacoding.miniproject2.service.ApplyService;
import site.metacoding.miniproject2.service.LikesService;
import site.metacoding.miniproject2.service.notWantedService;

@RequiredArgsConstructor
@RestController
public class WantedApiController {

    // private final WantedService wantedService;
    private final notWantedService wantedService;
    private final LikesService likesService;
    private final ApplyService applyService;

    @GetMapping("/api/wanted")
    public List<WantedListRespDto> findAll(SearchDto searchDto) {
        return wantedService.findAll(searchDto);
    }

    @GetMapping("/api/wanted/{id}")
    public void findById() {

    }

    @PostMapping("/s/api/wanted/{id}/like")
    public void wantedInsertLike() {

    }

    @PostMapping("/s/api/wanted/{id}/apply")
    public void wantedInsertApply() {

    }
}
