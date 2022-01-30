package com.wangshidai.eshopFront.service.impl;

import com.wangshidai.eshopFront.dao.UserDao;
import com.wangshidai.eshopFront.pojo.UserInfo;
import com.wangshidai.eshopFront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public Map findUser(UserInfo userInfo) {
        Map map = new HashMap();
        if(userDao.findUser(userInfo) != null){
            map.put("userInfo",userDao.findUser(userInfo));
            return map;
        }
        return map;
    }


}
