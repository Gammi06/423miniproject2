package site.metacoding.miniproject2.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.miniproject2.dto.SessionUsers;

public class UsersInterceptor implements HandlerInterceptor {
    // 지원 작업! 사용자권한 체크  주소 -> /s/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();
        SessionUsers sessionUser = (SessionUsers) session.getAttribute("principal");

        String httpMethod = request.getMethod();
        if (httpMethod.equals("PUT") || httpMethod.equals("DELETE") || httpMethod.equals("GET")) {
            if (sessionUser != null) {
                return true;
            }
            throw new RuntimeException("로그인이 필요합니다.");
        }
        // 지원 작업!

        return false;
    }
}