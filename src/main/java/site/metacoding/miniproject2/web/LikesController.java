package site.metacoding.miniproject2.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeFindByIdRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.service.LikesService;

@RequiredArgsConstructor
@RestController
public class LikesController {

    private final HttpSession session;
    private final LikesService likesService;

    @GetMapping("s/likes/{id}")
    public @ResponseBody CMRespDto<?> likeslist(@PathVariable Integer id, LikeFindByIdRespDto likeFindByIdRespDto) {
        SessionUsers sessionUsers = (SessionUsers) session.getAttribute("sessionUsers");
        likeFindByIdRespDto.setUserId(sessionUsers.getId());
        LikeFindByIdRespDto likesList = likesService.findById(id);
        return new CMRespDto<>(1, "구독페이지 보기", likesList);
    }
}
