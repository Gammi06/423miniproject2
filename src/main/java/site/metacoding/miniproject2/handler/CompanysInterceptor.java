package site.metacoding.miniproject2.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.miniproject2.dto.SessionUsers;

public class CompanysInterceptor implements HandlerInterceptor {
    // 지원 작업! 회사권한 체크 주소 -> /s/companys
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();
        SessionUsers sessionUser = (SessionUsers) session.getAttribute("principal");

        String httpMethod = request.getMethod();
        if (httpMethod.equals("PUT") || httpMethod.equals("DELETE") || httpMethod.equals("GET")) {
            if (sessionUser != null) {
                if (sessionUser.getRole.equals("일반")) {
                    return true;
                }
                throw new RuntimeException("권한이 없습니다.");
            }
            throw new RuntimeException("로그인이 필요합니다.");
        }
        // 지원 작업!

        return false;
    }
}