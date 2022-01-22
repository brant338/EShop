package com.wangshidai.eshop_front.controller;

import org.lanqiao.mvc.entity.ModelAndView;
import org.lanqiao.mvc.entity.YockMvcAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@YockMvcAnnotation.Controller("/user")
public class UserController {
    @YockMvcAnnotation.RequestMapping("/login.action")
    @YockMvcAnnotation.ResponseDispatch("/WEB-INF/views/sign-in.jsp")
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        return  modelAndView;
    }
}
