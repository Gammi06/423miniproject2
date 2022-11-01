package site.metacoding.miniproject2.config;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @RequiredArgsConstructor
@Configuration
public class FilterConfig {

    // private final UserRepository userRepository; // DI (스프링 IoC 컨테이너에서 옴)

    // IoC등록 (서버 실행시)
    /*
     * @Bean
     * public FilterRegistrationBean<JwtAuthenticationFilter>
     * jwtAuthenticationFilterRegister() {
     * log.debug("디버그 : 인증 필터 등록");
     * FilterRegistrationBean<JwtAuthenticationFilter> bean = new
     * FilterRegistrationBean<>(
     * new JwtAuthenticationFilter(userRepository));
     * bean.addUrlPatterns("/login");
     * bean.setOrder(1); // 낮은 순서대로 실행
     * return bean;
     * }
     * 
     * @Profile("dev")
     * 
     * @Bean
     * public FilterRegistrationBean<JwtAuthorizationFilter>
     * jwtAuthorizationFilterRegister() {
     * log.debug("디버그 : 인가 필터 등록");
     * FilterRegistrationBean<JwtAuthorizationFilter> bean = new
     * FilterRegistrationBean<>(
     * new JwtAuthorizationFilter());
     * bean.addUrlPatterns("/s/*"); // 원래 두개인데, 이 친구만 예외
     * bean.setOrder(2);
     * return bean;
     * }
     */

}