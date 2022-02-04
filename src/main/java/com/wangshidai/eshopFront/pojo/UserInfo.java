package com.wangshidai.eshopFront.pojo;

import com.wangshidai.eshopFront.service.UserService;
import com.wangshidai.eshopFront.service.impl.UserServiceImpl;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;
import java.util.Date;

public class UserInfo /*implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable*/ {
    private Integer user_id;   //用户ID
    private String user_name;  //用户名
    private String user_pwd;   //用户密码
    private String user_head;  //头像
    private String user_email;  //邮箱
    private String user_sex;    //性别
    private String user_phone;       //手机
    private String user_address; //详细地址(街道/门牌号)
    private Integer question_id;  //密保问题
    private String question_answer;  //密保答案
    private Integer is_activated;  //0默认代表未激活,1代表激活
    private Integer is_online;     //0代表默认离线,1代表上线
    private Date time;             //注册时间
    private String province_id;    //省份码
    private String city_id;        //市码
    private String area_id;        //区码
    private Double lat;            //维度
    private Double lng;            //经度

    private String password2;      //重复密码

    private String authCode;  //验证码 验证
    private Boolean user_remember; //记住用户状态

    private UserService userService = new UserServiceImpl();

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Boolean getUser_remember() {
        return user_remember;
    }

    public void setUser_remember(Boolean user_remember) {
        this.user_remember = user_remember;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_head() {
        return user_head;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(String question_answer) {
        this.question_answer = question_answer;
    }

    public Integer getIs_activated() {
        return is_activated;
    }

    public void setIs_activated(Integer is_activated) {
        this.is_activated = is_activated;
    }

    public Integer getIs_online() {
        return is_online;
    }

    public void setIs_online(Integer is_online) {
        this.is_online = is_online;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }



    @Override
    public String toString() {
        return "UserInfo{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_head='" + user_head + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_address='" + user_address + '\'' +
                ", question_id=" + question_id +
                ", question_answer='" + question_answer + '\'' +
                ", is_activated=" + is_activated +
                ", is_online=" + is_online +
                ", time=" + time +
                ", province_id='" + province_id + '\'' +
                ", city_id='" + city_id + '\'' +
                ", area_id='" + area_id + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", password2='" + password2 + '\'' +
                ", authCode='" + authCode + '\'' +
                ", user_remember=" + user_remember +
                '}';
    }
    /*//HttpSessionActivationListener接口的
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("userInfo对象跟着session一起钝化了");
        userService.updateOnlineStatus(this.getUser_id(),0);
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("userInfo对象跟着session一起活化了");
        userService.updateOnlineStatus(this.getUser_id(),1);
    }

    //HttpSessionBindingListener接口的

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("userInfo对象存入session中【上线】");

        userService.updateOnlineStatus(this.getUser_id(),1);

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("userInfo对象从session中移除【下线】");

        userService.updateOnlineStatus(this.getUser_id(),0);
    }*/
}
