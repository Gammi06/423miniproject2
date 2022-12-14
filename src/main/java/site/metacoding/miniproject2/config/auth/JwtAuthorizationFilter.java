package site.metacoding.miniproject2.config.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.UsersRespDto.AuthRespDto;

@Profile("dev")
@RequiredArgsConstructor
public class JwtAuthorizationFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger("JwtAuthorizationFilter 로그");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String jwtToken = req.getHeader("Authorization");
        logger.debug("디버그 토큰 : " + jwtToken);
        if (jwtToken == null) {
            customResponse("JWT 토큰이 없어서 인가할 수 없습니다", resp);
            return;
        }

        jwtToken = jwtToken.replace("Bearer ", "");
        jwtToken = jwtToken.trim();
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("구해줘용")).build().verify(jwtToken);

            Integer id = decodedJWT.getClaim("id").asInt();
            String userId = decodedJWT.getClaim("userId").asString();
            Integer companyId = decodedJWT.getClaim("companyId").asInt();
            AuthRespDto authRespDto = new AuthRespDto(id, userId, companyId);
            SessionUsers principal = new SessionUsers(authRespDto);
            HttpSession session = req.getSession();
            session.setAttribute("principal", principal);
        } catch (RuntimeException e) {
            e.printStackTrace();
            customResponse("토큰 검증 실패 : " + e.getMessage(), resp);
            return;
        }

        chain.doFilter(req, resp);
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
