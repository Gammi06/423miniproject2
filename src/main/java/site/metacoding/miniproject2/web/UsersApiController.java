package site.metacoding.miniproject2.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.UsersReqDto.JoinReqDto;
import site.metacoding.miniproject2.dto.UsersReqDto.LoginReqDto;
import site.metacoding.miniproject2.service.UsersService;

@RequiredArgsConstructor
@RestController
public class UsersApiController {
    private final UsersService usersService;
    private final HttpSession session;

    // 성유 작업
    @PostMapping("/join")
    public CMRespDto<?> join(@RequestBody JoinReqDto joinReqDto) { // 회원가입
        return new CMRespDto<>(1, "ok", usersService.insert(joinReqDto));
    }

    @PostMapping("/s/login")
    public CMRespDto<?> login(@RequestBody LoginReqDto loginReqDto) { // 로그인
        SessionUsers sessionUsers = usersService.findByUserId(loginReqDto);
        session.setAttribute("principal", sessionUsers);
        return new CMRespDto<>(1, "로그인 성공", sessionUsers.getUserId());
    }

    @DeleteMapping("/s/{id}/delete")
    public CMRespDto<?> delete(@PathVariable Integer id) { // 회원탈퇴
        usersService.deleteById(id);
        return new CMRespDto<>(1, "ok", null);
    }
    // 성유 작업 종료

    // 서현 작업
    @GetMapping("/s/mypage/{id}")
    public CMRespDto<?> findAllInfo(@PathVariable Integer id) {
        SessionUsers jwtUsers = (SessionUsers) session.getAttribute("jwtUsers");
        if (jwtUsers.getId() != id) {
            throw new RuntimeException("권한이 없습니다.");
        }
        return new CMRespDto<>(1, "성공", usersService.findAllInfo(id));
    }
    // 서현 작업 종료

}
