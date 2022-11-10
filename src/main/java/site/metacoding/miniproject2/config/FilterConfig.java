package site.metacoding.miniproject2.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.config.auth.JwtAuthenticationFilter;
import site.metacoding.miniproject2.config.auth.JwtAuthorizationFilter;
import site.metacoding.miniproject2.domain.users.UsersDao;
import site.metacoding.miniproject2.service.UsersService;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class FilterConfig {

    private final UsersService usersService;
    private final UsersDao usersDao;

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthenticationFilterRegister() {
        log.debug("디버그 : 인증 필터 등록");
        FilterRegistrationBean<JwtAuthenticationFilter> bean = new FilterRegistrationBean<>(
                new JwtAuthenticationFilter(usersService, usersDao));
        bean.addUrlPatterns("/login");
        bean.setOrder(1);
        return bean;
    }

    @Profile("dev")
    @Bean
    public FilterRegistrationBean<JwtAuthorizationFilter> jwtAuthorizationFilterRegister() {
        log.debug("디버그 : 인가 필터 등록");
        FilterRegistrationBean<JwtAuthorizationFilter> bean = new FilterRegistrationBean<>(
                new JwtAuthorizationFilter());
        bean.addUrlPatterns("/s/*");
        bean.setOrder(2);
        return bean;
    }
}