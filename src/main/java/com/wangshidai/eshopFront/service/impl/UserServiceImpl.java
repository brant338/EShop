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

    @Override
    public int Register(String user_name, String user_email, String user_pwd, String user_head, String user_sex, String province_id, String city_id, String area_id, String user_address, String question_id, String question_answer, String user_phone) {
        return userDao.Register(user_name,user_email,user_pwd,user_head,user_sex,province_id,city_id,area_id,user_address,question_id,question_answer,user_phone);
    }
}
