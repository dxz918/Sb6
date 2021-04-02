package com.turing.sb6.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.turing.sb6.interceptor.LoginInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource(){
       DruidDataSource dds=new DruidDataSource();
       return dds;
    }

    //批量配置视图控制器(只做页面跳转的控制器)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/").setViewName("login2");
        registry.addViewController("/user/index").setViewName("index");
        registry.addViewController("/user/dxz").setViewName("login3");
        registry.addViewController("/nav").setViewName("nav");
        registry.addViewController("/index").setViewName("index2");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/user/**")//拦截哪些路径
                .excludePathPatterns("/user/","/user/dxz","/user/login2","/css/**","/js/**");//不拦截哪些路径
    }
}
