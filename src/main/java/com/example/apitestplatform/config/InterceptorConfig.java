package com.example.apitestplatform.config;

import com.example.apitestplatform.interceptor.CorsInterceptor;
import com.example.apitestplatform.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName InterceptorConfig
 * @Description 拦截器配置
 * @Author ZhangJia
 * @Date 2020/10/22
 * @Version 1.0
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截全部路径，跨域访问策略放在最上面
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");
        //拦截全部
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                //不拦截哪些路径
                .excludePathPatterns("/api/v1/pri/user/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
