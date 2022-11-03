package site.metacoding.miniproject2.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.UsersReqDto.LoginReqDto;
import site.metacoding.miniproject2.service.UsersService;

@RequiredArgsConstructor
@RestController
public class UsersApiController {
    private final UsersService usersService;
    private final HttpSession session;

    @PostMapping("/login")
    public CMRespDto<?> login(@RequestBody LoginReqDto loginReqDto) {
        SessionUsers sessionUsers = usersService.findByUserId(loginReqDto);
        session.setAttribute("sessionUsers", sessionUsers);
        return new CMRespDto<>(1, "ok", sessionUsers);
    }

}
