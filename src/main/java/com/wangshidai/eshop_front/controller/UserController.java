package com.wangshidai.eshop_front.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import org.lanqiao.mvc.entity.ModelAndView;
import org.lanqiao.mvc.entity.YockMvcAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@YockMvcAnnotation.Controller("/user")
public class UserController {
    @YockMvcAnnotation.RequestMapping("/showLogin.action")
    @YockMvcAnnotation.ResponseDispatch("/WEB-INF/views/sign-in.jsp")
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        return  modelAndView;
    }
    @YockMvcAnnotation.RequestMapping("/captcha.action")
    public void captchaGenerator(HttpServletRequest request,
                                 HttpServletResponse response){
        //生成验证码
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(180, 50, 4, 6);
        request.getSession().setAttribute("captcha",shearCaptcha);
        //写出到输出流
        try {

            shearCaptcha.write(response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
