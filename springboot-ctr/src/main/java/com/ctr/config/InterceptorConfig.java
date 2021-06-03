package com.ctr.config;

import com.ctr.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/error","/user/login","/user/register","/categories",
                        "/products","/products/*","/public/**",
                        "/api/v1/admin/**",
                        "/",
                        "/**.html",
                        "/**.js",
                        "/**.ico",
                         "/page/**",
                         "/page/**",
                        "/layui/css/**",
                        "layui/lay/modules/**",
                        "/css/**",
                        "/layui/**",
                        "/images/**",
                        "/js/**",
                        "/json/**"
                        );
    }

}
