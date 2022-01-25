package com.wangshidai.eshop_front.service.impl;

import com.wangshidai.eshop_front.dao.UserDao;
import com.wangshidai.eshop_front.dao.impl.UserDaoImpl;
import com.wangshidai.eshop_front.pojo.UserInfo;
import com.wangshidai.eshop_front.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public UserInfo findUser(UserInfo userInfo) {
        return userDao.findUser(userInfo);
    }
}
