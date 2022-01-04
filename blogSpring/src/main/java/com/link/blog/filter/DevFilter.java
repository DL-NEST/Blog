package com.link.blog.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dl-nest
 * @apiNote
 * @date 2021/11/25 20:55
 */
public class DevFilter implements HandlerInterceptor {
    /**
     * @param request:
     * @param response:
     * @param handler:
     * @apiNote 拦截，判断为true的时候放行
     * @author dl-nest
     * @date 2021/11/25 17:46
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = response.getHeader("token");
        System.out.println(token);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}