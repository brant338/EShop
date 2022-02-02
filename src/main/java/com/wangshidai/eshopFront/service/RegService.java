package com.wangshidai.eshopFront.service;

import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.pojo.UserInfo;


import java.util.List;


public interface RegService {



    List<PwdQuestion> findPwdQuestion();

    int register(UserInfo userInfo);

    void updateActivated(int uuid);

    UserInfo selectUserById(UserInfo userInfo);
}
