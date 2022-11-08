package site.metacoding.miniproject2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import site.metacoding.miniproject2.handler.CompanysInterceptor;
import site.metacoding.miniproject2.handler.UsersInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {// 인터셉터용

    public void addInterceptorsUser(InterceptorRegistry registry) {
        registry.addInterceptor(new UsersInterceptor()).addPathPatterns("/s/**");
    }

    public void addInterceptorsCompanys(InterceptorRegistry registry) {
        registry.addInterceptor(new CompanysInterceptor()).addPathPatterns("/s/api/companys/**");
    }

}
