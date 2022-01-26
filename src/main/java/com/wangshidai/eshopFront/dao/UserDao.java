package com.wangshidai.eshopFront.dao;

import com.wangshidai.eshopFront.pojo.UserInfo;

public interface UserDao {
    UserInfo findUser(UserInfo userInfo);
}
