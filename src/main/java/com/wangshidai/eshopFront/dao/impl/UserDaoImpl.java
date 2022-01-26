package com.wangshidai.eshopFront.dao.impl;

import com.wangshidai.eshopFront.dao.UserDao;
import com.wangshidai.eshopFront.pojo.UserInfo;
import com.wangshidai.eshopFront.utils.MyJdbcUtilsV5;

public class UserDaoImpl implements UserDao {

    @Override
    public UserInfo findUser(UserInfo userInfo) {
        return MyJdbcUtilsV5.acquareFileldToBeanOneLine(UserInfo.class,
                "select * from tb_user where (user_name = ? or user_email = ?) and user_pwd = ?",
                userInfo.getUser_name(),userInfo.getUser_email(),userInfo.getUser_pwd());
    }
}
