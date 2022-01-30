package com.wangshidai.eshopFront.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.entity.ResultBean;
import com.wangshidai.eshopFront.pojo.UserInfo;
import com.wangshidai.eshopFront.service.RegService;
import com.wangshidai.eshopFront.utils.JsonUtils;
import com.wangshidai.eshopFront.utils.MailUtilByYock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegController {

    @Autowired
    private RegService regService;

    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request,
                                 HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;

    }
    @RequestMapping("/newRegister")
    public void newRegister(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {

        UserInfo userInfo = JsonUtils.parseJSON2Object(request, UserInfo.class);

        //进行md5撒盐加密两次
        String salt = "!@#"+userInfo.getUser_pwd()+"$";
        String user_pwd = SecureUtil.md5(SecureUtil.md5(salt));
        userInfo.setUser_pwd(user_pwd);

        int uid =
                regService.Register(userInfo);
        String verifyUrl = "http://"+request.getServerName()+":"+request.getServerPort()+"/eshop_front/user/verify_activated_account.action?uuid="+uid;
        String content = "亲爱的"+userInfo.getUser_name()+",您好<br/>"
                + "已经收到了您的注册信息.请点击以下确认链接,立即激活Eshop账号: <br/>"
                +"<a href=\""+verifyUrl+"\"><h3>完成注册,立即体验娱乐之旅</h3></a>"
                +"如果不能点击该链接地址,请复制并粘贴到浏览器的地址输入框<br />"+ verifyUrl;
        boolean result = MailUtilByYock.sendMail(userInfo.getUser_email(),userInfo.getUser_name(),"请完成EShop用户注册",content);
        System.out.println(uid);
    }

    @RequestMapping("/verify_activated_account.action")
    public void verifyActivatedAccount(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("uuid") int uuid
    ) throws Exception {

        //激活状态
        regService.updateActivated(uuid);

        //通过ID查询出用户信息，并保存在session
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_id(uuid);
        UserInfo loginUser = regService.selectUserById(userInfo);
        request.getSession().setAttribute("user",loginUser);

        //跳转到首页地址
        response.sendRedirect("/eshop_front");
    }

    @RequestMapping("/pwdQuestion")
    public void findPwdQuestion(HttpServletRequest request,
                                HttpServletResponse response){
        List<PwdQuestion> pwdQuestions =  regService.findPwdQuestion();

        try {

            response.getWriter().write(JSON.toJSONString(new ResultBean(true,pwdQuestions)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/captcha.action")
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
    @RequestMapping("/check_captcha.action")
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
}
