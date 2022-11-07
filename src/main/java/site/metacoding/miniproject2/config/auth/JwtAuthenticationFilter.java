package site.metacoding.miniproject2.config.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.UsersReqDto.LoginReqDto;
import site.metacoding.miniproject2.dto.UsersRespDto.AuthRespDto;
import site.metacoding.miniproject2.service.UsersService;
import site.metacoding.miniproject2.util.SHA256;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements Filter {

    private final UsersService usersService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (!req.getMethod().equals("POST")) {
            customResponse("로그인시에는 post요청을 해야 합니다.", resp);
            return;
        }

        ObjectMapper om = new ObjectMapper();
        LoginReqDto loginReqDto = om.readValue(req.getInputStream(), LoginReqDto.class);
        log.debug("디버그 : " + loginReqDto.getUserId());
        log.debug("디버그 : " + loginReqDto.getUserPassword());

        Optional<AuthRespDto> usersOP = usersService.findByUserIdOP(loginReqDto);
        if (usersOP.isEmpty()) {
            customResponse("유저네임을 찾을 수 없습니다.", resp);
            return;
        }

        AuthRespDto usersPS = usersOP.get();

        // SHA256 sh = new SHA256();
        // String encPassword = sh.encrypt(loginReqDto.getUserPassword());
        // if (!usersPS.getUserPassword().equals(encPassword)) {
        // customResponse("패스워드가 틀렸습니다.", resp);
        // return;
        // }

        if (!usersPS.getUserPassword().equals(loginReqDto.getUserPassword())) {
            customResponse("패스워드가 틀렸습니다.", resp);
            return;
        }

        Date expire = new Date(System.currentTimeMillis() + (1000 * 60 * 60));

        String jwtToken = JWT.create()
                .withSubject("구해줘용")
                .withExpiresAt(expire)
                .withClaim("id", usersPS.getId())
                .withClaim("userId", usersPS.getUserId())
                .withClaim("companyId", usersPS.getCompanyId())
                .sign(Algorithm.HMAC512("구해줘용"));
        log.debug("디버그 : " + jwtToken);

        // JWT토큰 응답
        customJwtResponse(jwtToken, usersPS, resp);

        // chain.doFilter(req, resp);
    }

    private void customJwtResponse(String token, AuthRespDto usersPS, HttpServletResponse resp)
            throws IOException, JsonProcessingException {
        resp.setContentType("application/json; charset=utf-8");
        resp.setHeader("Authorization", "Bearer " + token);
        PrintWriter out = resp.getWriter();
        resp.setStatus(200);
        CMRespDto<?> cmRespDto = new CMRespDto<>(1, "성공", new SessionUsers(usersPS));
        ObjectMapper om = new ObjectMapper();
        String body = om.writeValueAsString(cmRespDto);
        out.println(body);
        out.flush();
    }

    private void customResponse(String msg, HttpServletResponse resp) throws IOException, JsonProcessingException {
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        resp.setStatus(400);
        CMRespDto<?> cmRespDto = new CMRespDto<>(-1, msg, null);
        ObjectMapper om = new ObjectMapper();
        String body = om.writeValueAsString(cmRespDto);
        out.println(body);
        out.flush();
    }

}