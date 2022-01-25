package com.wangshidai.eshop_front.dao;

import com.wangshidai.eshop_front.pojo.UserInfo;

public interface UserDao {
    UserInfo findUser(UserInfo userInfo);
}
