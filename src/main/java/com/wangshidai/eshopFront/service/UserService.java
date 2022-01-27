package com.wangshidai.eshopFront.service;

import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.pojo.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo findUser(UserInfo userInfo);

    List<PwdQuestion> findPwdQuestion();
}
