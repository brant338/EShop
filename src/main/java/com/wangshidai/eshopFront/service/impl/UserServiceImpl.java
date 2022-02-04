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

    @Override
    public void updateOnlineStatus(int user_id, int status) {
        Map map = new HashMap();
        map.put("user_id",user_id);
        map.put("status",status);

        userDao.updateOnlineStatus(map);
    }

    @Override
    public Map findUserById(int user_id) {
        Map map = new HashMap();
        if(userDao.findUserById(user_id) != null){
            map.put("userInfo",userDao.findUserById(user_id));
        }
        return map;
    }


}
