package site.metacoding.miniproject2.web;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.SubribesRespDto.SubscribesListRespDto;
import site.metacoding.miniproject2.service.SubcribesService;

@RequiredArgsConstructor
@RestController
public class SubcribesController {

    private final SubcribesService subcribesService;

    @GetMapping("s/api/subscribes/{id}")
    public String subscribesform(@PathVariable Integer id, Model model) {
        List<SubscribesListRespDto> subcribesList = subcribesService.subcribesListPage(id);
        model.addAttribute("subcribesList", subcribesList);
        return "subscribes/subscribes";
    }

}
