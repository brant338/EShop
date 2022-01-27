package com.wangshidai.eshopFront.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //过滤编码格式ֵ
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取请求的URI(请求地址)
        String uri = request.getRequestURI();
        if("/eshop_front/user/member.action".equals(uri) ||
        "/eshop_front/user/history.action".equals(uri)){
            Object user = request.getSession().getAttribute("user");
            if(user == null){
                request.getSession().setAttribute("loginFrontURL",uri);
                response.sendRedirect("/eshop_front/user/showLogin.action");
            }else{
            //放行
            filterChain.doFilter(request,response);
        }
        }else{
            //放行
            filterChain.doFilter(request,response);
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
