package com.wangshidai.eshopFront.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.entity.ResultBean;
import com.wangshidai.eshopFront.pojo.UserInfo;
import com.wangshidai.eshopFront.service.UserService;
import com.wangshidai.eshopFront.service.impl.UserServiceImpl;
import com.wangshidai.eshopFront.utils.JsonUtils;
import com.wangshidai.eshopFront.utils.MailUtilByYock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showLogin")
    public ModelAndView showLogin(HttpServletRequest request,
                              HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sign-in");
        return  modelAndView;
    }

    @RequestMapping("/captcha")
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
    @RequestMapping("/check_captcha")
    public void checkCaptcha(HttpServletRequest request,
                               HttpServletResponse response,
                               @RequestParam("authCode") String authCode){
        try {

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

    @RequestMapping("/login")
    public void login(HttpServletRequest request,
                      HttpServletResponse response,
                      @RequestBody UserInfo userInfo){
        try {
            Map returnMap = new HashMap();
            String pwd = userInfo.getUser_pwd();
            //进行md5撒盐加密两次
            String salt = "!@#"+pwd+"$";
            pwd = SecureUtil.md5(SecureUtil.md5(salt));
            userInfo.setUser_pwd(pwd);

            Map map = userService.findUser(userInfo);

            //取出验证码
            ShearCaptcha captcha = (ShearCaptcha)request.getSession().getAttribute("captcha");
            if(captcha.verify(userInfo.getAuthCode())){
                UserInfo userInfo1 = (UserInfo) map.get("userInfo");
                //响应数据
                if(map.get("userInfo") != null){
                    //保存用户信息至session中
                    request.getSession().setAttribute("user",userInfo);
                    //记住用户状态
                    if(userInfo.getUser_remember()){
                        Cookie cookie = new Cookie("user_id", (userInfo1.getUser_id()+""));
                        cookie.setMaxAge(60*60*24*14);
                        cookie.setPath("/eshop_front/");
                        response.addCookie(cookie);
                    }

                    //记住被拦截之前的地址
                    String loginFrontURL = (String) request.getSession().getAttribute("loginFrontURL");
                    if(loginFrontURL != null){
                        returnMap.put("notify_url",loginFrontURL);
                        request.getSession().removeAttribute("loginFrontURL");
                    }else{
                        returnMap.put("notify_url","/eshop_front");
                    }
                    response.getWriter().write(JSON.toJSONString(new ResultBean(true,returnMap)));

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

    @RequestMapping("/logOut")
    public ModelAndView logOut(HttpServletRequest request,
                       HttpServletResponse response){

        request.getSession().removeAttribute("user");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sign-in");
        return modelAndView;
    }

    @RequestMapping("/member")
    public ModelAndView memberPage(HttpServletRequest request,
                                   HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("member_set");
        return modelAndView;

    }
}
