package com.wangshidai.eshopFront.service.impl;

import com.wangshidai.eshopFront.dao.UserDao;
import com.wangshidai.eshopFront.dao.impl.UserDaoImpl;
import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.pojo.UserInfo;
import com.wangshidai.eshopFront.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public UserInfo findUser(UserInfo userInfo) {
        return userDao.findUser(userInfo);
    }

    @Override
    public List<PwdQuestion> findPwdQuestion() {
        return userDao.findPwdQuestion();
    }
}
