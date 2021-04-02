package com.turing.sb6.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    //在处理控制器之前会自动调用的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("userl");
        if(user==null){
            log.info("拦截了");
            //request.getContextPath():获取上下文路径
            response.sendRedirect(request.getContextPath()+"/user/");
           return false;
        }else{
            log.info("放行了");
           return true;
        }
    }

}
