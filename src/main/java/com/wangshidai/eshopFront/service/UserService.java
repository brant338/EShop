package com.wangshidai.eshopFront.service;

import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.pojo.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo findUser(UserInfo userInfo);

    List<PwdQuestion> findPwdQuestion();

    int Register(String user_name, String user_email, String user_pwd, String user_head, String user_sex, String province_id, String city_id, String area_id, String user_address, String question_id, String question_answer, String user_phone);
}
