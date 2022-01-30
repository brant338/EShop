package com.wangshidai.eshopFront.service;


import com.wangshidai.eshopFront.pojo.UserInfo;

import java.util.Map;


public interface UserService {
    Map findUser(UserInfo userInfo);

}
