package com.aliyunstudy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**定义拦截器
 * Created by lvyihang on 17/5/21.
 */
public class CommonInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        定义相对路径
//        String path = request.getContextPath();
//        String scheme = request.getScheme();
//        String serverName = request.getServerName();
//        int port = request.getServerPort();
//        String basePath = scheme + "://" + serverName + ":" + port + path;
//        request.setAttribute("basePath", basePath);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
