package site.metacoding.miniproject2.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedLisLikestRespDto;
import site.metacoding.miniproject2.service.LikesService;

@RequiredArgsConstructor
@RestController
public class LikesApiController {

    private final HttpSession session;
    private final LikesService likesService;

    /* 지원 작업 */
    @GetMapping("/s/mypage/{userId}/likes")
    public CMRespDto<?> findLikeList(@PathVariable Integer userId) {
<<<<<<< HEAD
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        List<WantedLisLikestRespDto> WantedListRespDto = likesService.findLikeList(userId);
        return new CMRespDto<>(1, "좋아요페이지 보기", WantedListRespDto);
    }
    /*  지원 작업 완료! */
=======
        SessionUsers sessionUsers = (SessionUsers) session.getAttribute("sessionUsers");
        List<WantedLisLikestRespDto> WantedListRespDto = likesService.findLikeList(userId);
        return new CMRespDto<>(1, "좋아요페이지 보기", WantedListRespDto);
    }
    /* 지원 작업 완료! */
>>>>>>> 6c1f647bbe8a5d1d6c33944ee290394b075faa76

}