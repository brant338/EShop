package com.wangshidai.eshopFront.filter;

import com.wangshidai.eshopFront.dao.UserDao;
import com.wangshidai.eshopFront.pojo.UserInfo;
import com.wangshidai.eshopFront.service.UserService;
import com.wangshidai.eshopFront.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.jws.soap.SOAPBinding;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class FilterLogin implements Filter {


    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取容器,完成注入
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("spring_tx.xml");
        userService =(UserService)act.getBean("userServiceImpl");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //先从session中寻找user
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");

        //获取请求的URI(请求地址)
        String uri = request.getRequestURI();
        if ("/eshop_front/user/member".equals(uri) ||
            "/eshop_front/user/history".equals(uri)) {
            if (user == null) {
                //先从cookie中寻找user_id
                Cookie[] cookies = request.getCookies();
                boolean mark = true;
                for (Cookie cookie : cookies) {
                    if (("user_id").equals(cookie.getName())) {
                        mark = false;
                        int user_id = Integer.parseInt(cookie.getValue());

                        Map map = userService.findUserById(user_id);
                        request.getSession().setAttribute("user", map.get("userInfo"));
                        filterChain.doFilter(request, response);
                    }
                }
                if (mark) {
                    request.getSession().setAttribute("loginFrontURL", uri);
                    response.sendRedirect("/eshop_front/user/showLogin");
                }
            } else {
                //放行
                filterChain.doFilter(request, response);
            }
        } else {
            //放行
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        //Filter.super.destroy();
    }

}
