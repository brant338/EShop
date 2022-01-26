package com.wangshidai.eshopFront.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.alibaba.fastjson.JSON;
import com.wangshidai.eshopFront.entity.ResultBean;
import com.wangshidai.eshopFront.pojo.UserInfo;
import com.wangshidai.eshopFront.service.UserService;
import com.wangshidai.eshopFront.service.impl.UserServiceImpl;
import org.lanqiao.mvc.entity.ModelAndView;
import org.lanqiao.mvc.entity.YockMvcAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@YockMvcAnnotation.Controller("/user")
public class UserController {

    private UserService userService = new UserServiceImpl();

    @YockMvcAnnotation.RequestMapping("/showLogin.action")
    @YockMvcAnnotation.ResponseDispatch("/WEB-INF/views/sign-in.jsp")
    public ModelAndView showLogin(HttpServletRequest request,
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
    @YockMvcAnnotation.RequestMapping("/check_captcha.action")
    @YockMvcAnnotation.ResponseVoid
    public void checkCaptcha(HttpServletRequest request,
                               HttpServletResponse response,
                               @YockMvcAnnotation.RequestParam(name = "authCode") String authCode){
        try {
            //过滤编码格式ֵ
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=UTF-8");
            //取出验证码
            ShearCaptcha captcha = (ShearCaptcha)request.getSession().getAttribute("captcha");
            if(captcha.verify(authCode)){
                response.getWriter().write(JSON.toJSONString(new ResultBean(true,"验证码正确")));
            }else{
                response.getWriter().write(JSON.toJSONString(new ResultBean(false,"验证码错误")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @YockMvcAnnotation.RequestMapping("/login.action")
    @YockMvcAnnotation.ResponseVoid
    public void login(HttpServletRequest request,
                      HttpServletResponse response,
                      @YockMvcAnnotation.RequestParam(name = "authCode") String authCode,
                      @YockMvcAnnotation.RequestParam(name = "username") String username,
                      @YockMvcAnnotation.RequestParam(name = "pwd") String pwd){
        try {
            //过滤编码格式ֵ
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=UTF-8");

            Map returnMap = new HashMap();

            //封装数据
            UserInfo userInfo = new UserInfo();
            userInfo.setUser_name(username);
            userInfo.setUser_pwd(pwd);

            UserInfo userInfo1 = userService.findUser(userInfo);

            //取出验证码
            ShearCaptcha captcha = (ShearCaptcha)request.getSession().getAttribute("captcha");
            if(captcha.verify(authCode)){
                //响应数据
                if(userInfo1.getUser_name() != null){
                    //保存用户信息至session中
                    request.getSession().setAttribute("user",userInfo);

                    String loginFrontURL = (String) request.getSession().getAttribute("loginFrontURL");
                    if(loginFrontURL != null){
                        returnMap.put("notify_url",loginFrontURL);
                        request.getSession().removeAttribute("loginFrontURL");
                    }else{
                        returnMap.put("notify_url","/eshop_front");
                    }

                    response.getWriter().write(JSON.toJSONString(new ResultBean(true,returnMap,"查询用户成功")));

                }else{
                    response.getWriter().write(JSON.toJSONString(new ResultBean(false,"用户名或密码错误")));
                }
            }else{
                response.getWriter().write(JSON.toJSONString(new ResultBean(false,"验证码错误")));
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @YockMvcAnnotation.RequestMapping("/logOut.action")
    @YockMvcAnnotation.ResponseDispatch("/WEB-INF/views/sign-in.jsp")
    public ModelAndView logOut(HttpServletRequest request,
                       HttpServletResponse response){

        request.getSession().removeAttribute("user");

        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @YockMvcAnnotation.RequestMapping("/member.action")
    @YockMvcAnnotation.ResponseDispatch("/WEB-INF/views/member_set.jsp")
    public ModelAndView memberPage(HttpServletRequest request,
                                   HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;

    }
}
