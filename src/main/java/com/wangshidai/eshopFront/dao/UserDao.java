package com.wangshidai.eshopFront.dao;

import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.pojo.UserInfo;

import java.util.List;

public interface UserDao {
    UserInfo findUser(UserInfo userInfo);

    List<PwdQuestion> findPwdQuestion();
}
