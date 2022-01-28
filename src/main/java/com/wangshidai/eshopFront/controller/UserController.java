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
import org.lanqiao.mvc.entity.ModelAndView;
import org.lanqiao.mvc.entity.YockMvcAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
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
            Map returnMap = new HashMap();

            //进行md5撒盐加密两次
            String salt = "!@#"+pwd+"$";
            pwd = SecureUtil.md5(SecureUtil.md5(salt));

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

    @YockMvcAnnotation.RequestMapping("/register.action")
    @YockMvcAnnotation.ResponseDispatch("/WEB-INF/views/register.jsp")
    public ModelAndView register(HttpServletRequest request,
                         HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;

    }
    @YockMvcAnnotation.RequestMapping("/newRegister.action")
    @YockMvcAnnotation.ResponseVoid
    public void newRegister(HttpServletRequest request,
                            HttpServletResponse response,
                            @YockMvcAnnotation.RequestParam(name = "user_email") String user_email,
                            @YockMvcAnnotation.RequestParam(name = "user_name") String user_name,
                            @YockMvcAnnotation.RequestParam(name = "user_pwd") String user_pwd,
                            @YockMvcAnnotation.RequestParam(name = "user_head") String user_head,
                            @YockMvcAnnotation.RequestParam(name = "user_sex") String user_sex,
                            @YockMvcAnnotation.RequestParam(name = "password2") String password2,
                            @YockMvcAnnotation.RequestParam(name = "province_id") String province_id,
                            @YockMvcAnnotation.RequestParam(name = "city_id") String city_id,
                            @YockMvcAnnotation.RequestParam(name = "area_id") String area_id,
                            @YockMvcAnnotation.RequestParam(name = "user_address") String user_address,
                            @YockMvcAnnotation.RequestParam(name = "question_id") String question_id,
                            @YockMvcAnnotation.RequestParam(name = "question_answer") String question_answer,
                            @YockMvcAnnotation.RequestParam(name = "is_activated") String is_activated,
                            @YockMvcAnnotation.RequestParam(name = "is_online") String is_online,
                            @YockMvcAnnotation.RequestParam(name = "time") String time,
                            @YockMvcAnnotation.RequestParam(name = "user_phone") String user_phone,
                            @YockMvcAnnotation.RequestParam(name = "authCode") String authCode){
        //进行md5撒盐加密两次
        String salt = "!@#"+user_pwd+"$";
        user_pwd =SecureUtil.md5(SecureUtil.md5(salt));

        int uid =
                userService.Register(user_name,user_email,user_pwd,user_head,user_sex,province_id,city_id,area_id,user_address,question_id,question_answer,user_phone);
        String verifyUrl = "http://"+request.getServerName()+":"+request.getServerPort()+"/eshop_front/user/verify_activated_account.action?uuid="+uid;
        String content = "亲爱的"+user_name+",您好<br/>"
                + "已经收到了您的注册信息.请点击以下确认链接,立即激活Eshop账号: <br/>"
                +"<a href=\""+verifyUrl+"\"><h3>完成注册,立即体验娱乐之旅</h3></a>"
                +"如果不能点击该链接地址,请复制并粘贴到浏览器的地址输入框<br />"+ verifyUrl;
        boolean result = MailUtilByYock.sendMail(user_email,user_name,"请完成EShop用户注册",content);
        System.out.println(uid);
    }

    @YockMvcAnnotation.RequestMapping("/verify_activated_account.action")
    @YockMvcAnnotation.ResponseVoid
    public void verifyActivatedAccount(
            HttpServletRequest request,
            HttpServletResponse response,
            @YockMvcAnnotation.RequestParam(name = "uuid") int uuid
    ) throws Exception {

        //激活状态
        userService.updateActivated(uuid);

        //通过ID查询出用户信息，并保存在session
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_id(uuid);
        UserInfo loginUser = userService.selectUserById(userInfo);
        request.getSession().setAttribute("user",loginUser);

        //跳转到首页地址
        response.sendRedirect("/eshop_front");
    }

    @YockMvcAnnotation.RequestMapping("/pwdQuestion.action")
    @YockMvcAnnotation.ResponseVoid
    public void findPwdQuestion(HttpServletRequest request,
                                HttpServletResponse response){
        List<PwdQuestion> pwdQuestions =  userService.findPwdQuestion();

        try {

            response.getWriter().write(JSON.toJSONString(new ResultBean(true,pwdQuestions)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
